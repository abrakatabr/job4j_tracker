package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenSaveItemAndReplaceThenItemShouldChange() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("Alex");
        Item item2 = new Item("Ivan");
        tracker.add(item1);
        item2.setId(item1.getId());
        assertThat(tracker.replace(item1.getId(), item2)).isTrue();
        assertThat(tracker.findById(item2.getId())).isEqualTo(item2);
    }

    @Test
    public void whenSaveItemAndDeleteThenItemIsNull() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("Alex");
        tracker.add(item);
        tracker.delete(item.getId());
        assertThat(tracker.findById(item.getId())).isNotEqualTo(item);
    }

    @Test
    public void whenFindAllThenCorrect() {
        SqlTracker tracker = new SqlTracker(connection);
        List<Item> items = new ArrayList<>();
        Item item1 = new Item("Alex");
        Item item2 = new Item("Pavel");
        Item item3 = new Item("Ivan");
        Item item4 = new Item("Evgen");
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        for (Item item : items) {
            tracker.add(item);
        }
        assertThat(tracker.findAll()).containsAll(items);
    }

    @Test
    public void whenFindByNameThenCorrect() {
        SqlTracker tracker = new SqlTracker(connection);
        List<Item> items = new ArrayList<>();
        Item item1 = new Item("Alex");
        Item item2 = new Item("Pavel");
        Item item3 = new Item("Ivan");
        Item item4 = new Item("Evgen");
        Item item5 = new Item("Alex");
        items.add(item1);
        items.add(item5);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item5);
        assertThat(tracker.findByName("Alex")).containsAll(items);
    }
}