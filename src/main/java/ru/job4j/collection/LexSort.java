package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        Integer numberLeft = Integer.parseInt(left.split(". ")[0]);
        Integer numberRight = Integer.parseInt(right.split(". ")[0]);
        return Integer.compare(numberLeft, numberRight);
    }
}
