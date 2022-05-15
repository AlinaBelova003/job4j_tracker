package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("alinka_belova_2003@mail.ru", "Alina Belova");
        for (String kay : map.keySet()) {
            System.out.println(kay);
        }
    }
}
