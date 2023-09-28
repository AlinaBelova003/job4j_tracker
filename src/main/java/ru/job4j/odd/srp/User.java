package ru.job4j.odd.srp;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Нарушение spr.
 * Один класс ответственен за разные действия.
 * Сложен в поддерживание и изменениях
 */
public class User {
    private String name;
    private int number;

    Map<String, Object> map = new HashMap<>();

    public User(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void printName(String name) {
        System.out.println(name);
    }

    public static Map<String, Integer> putValue(Map<String, Integer> map) {
        map.put("Ivan", 894394839);
        map.put("Selin", 889678585);
        return map;
    }

    public static Map<String, Object> findUser(Map<String, Integer> map) {
        return map.entrySet()
                .stream()
                .filter(number -> number.getKey().startsWith("Iv"))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Map<String, Object> sortValue(Map<String, Integer> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new
                ));
    }
}
