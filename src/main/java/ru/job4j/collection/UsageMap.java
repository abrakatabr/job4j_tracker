package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Ivan@yandex.ru", "Иван Иванович Иванов");
        map.put("Alex@yandex.ru", "Александр Александрович Александров");
        map.put("Boris@yandex.ru", "Борис Борисовыч Борисов");
        for (String key : map.keySet()) {
            String name = map.get(key);
            System.out.println("ФИО: " + name + ", почта: " + key);
        }
    }
}
