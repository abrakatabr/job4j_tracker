package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1Split = o1.split("/");
        String[] o2Split = o2.split("/");
        int minLength = Math.min(o1Split.length, o2Split.length);
        if (!o1Split[0].equals(o2Split[0])) {
            return o2Split[0].compareTo(o1Split[0]);
        }
        for (int i = 1; i < minLength; i++) {
            if (o2Split[i].equals(o1Split[i])) {
                continue;
            }
            return o1Split[i].compareTo(o2Split[i]);
        }
        return Integer.compare(o1Split.length, o2Split.length);
    }
}
