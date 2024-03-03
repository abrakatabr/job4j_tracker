package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ItemDescByNameTest {
    @Test
    public void whenAscSort() {
        List<Item> items = Arrays.asList(
                new Item(1, "Gleb"),
                new Item(2, "Alex"),
                new Item(3, "Den")
        );
        List<Item> expected = Arrays.asList(
                new Item(1, "Gleb"),
                new Item(3, "Den"),
                new Item(2, "Alex")
        );
        Collections.sort(items, new ItemDescByName());
        assertThat(items).containsExactlyElementsOf(expected);
    }
}