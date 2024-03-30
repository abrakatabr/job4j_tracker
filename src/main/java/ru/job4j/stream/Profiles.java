package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }

    public static List<Address> collectSortWithoutDuplicate(List<Profile> profiles) {
        Comparator<Address> comparator = (address1, address2) -> address1.getCity().compareTo(address2.getCity());
        return profiles.stream()
                .map(Profile::getAddress)
                .sorted(comparator)
                .distinct()
                .collect(Collectors.toList());
    }
}
