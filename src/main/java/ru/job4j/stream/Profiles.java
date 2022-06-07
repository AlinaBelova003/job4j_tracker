package ru.job4j.stream;

import java.util.ArrayList;
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
}
