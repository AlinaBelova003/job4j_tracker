package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    /**
     * Метод преобразует список профилей в список адрессов.
     * @param profiles параметр профиля
     */
    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }

    public static List<Address> collectSortWithoutDuplicate(List<Profile> profiles) {
        Comparator<Address> addressComparator = (x, y) -> x.getCity().compareTo(y.getCity());
        return profiles.stream()
                .map(Profile ::getAddress)
                .sorted(addressComparator)
                .distinct()
                .collect(Collectors.toList());
    }
}
