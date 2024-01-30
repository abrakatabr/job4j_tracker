package ru.job4j.oop;

import java.util.Objects;

public class College {
    public static void main(String[] args) {
        Freshman freshman = new Freshman();
        Student freshman1 = freshman;
        Object freshman2 = freshman1;
    }
}
