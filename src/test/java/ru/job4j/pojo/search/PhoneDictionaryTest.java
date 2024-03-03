package ru.job4j.pojo.search;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import ru.job4j.search.Person;
import ru.job4j.search.PhoneDictionary;

import static org.assertj.core.api.Assertions.*;

class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    public void whenNotFoundThenEmptyList() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Alex", "Pozharov", "9344423", "Moscow")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.isEmpty()).isTrue();
    }
}