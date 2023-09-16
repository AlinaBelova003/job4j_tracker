package ru.job4j.lambda;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

public class IterableLambdaUsage {
    public static void main(String[] args) {
        Iterable<String> iterable = Arrays.asList(
                "name",
                "SecondName",
                "Age",
                "birthday"
        );

        iterable.forEach(System.out::println);
        System.out.println(" ");

        System.out.println(" ");

        Collection<String> collection = new ArrayList<>();
        collection.add("name");
        collection.add("top");
        collection.add("user");
        collection.add("precision");
        collection.add("post");

        System.out.println(collection.removeIf(s -> s.length() == 4));
        System.out.println(collection);

        System.out.println(" ");

        List<Integer> list = Arrays.asList(4, 7, 2, 543, 86, 23);
        list.forEach(s -> System.out.println("Текущие значение: " + s));
        UnaryOperator<Integer> unaryOperator = integer -> integer * integer;
        list.replaceAll(unaryOperator);
        list.forEach(s -> System.out.println("Значение после преобразования: " + s));
        System.out.println(" ");

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "name");
        map.put(2, "top");
        map.put(3, "user");
        map.put(4, "precision");
        map.put(5, "post");
        map.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
        System.out.println(" ");

        BiFunction<Integer, String, String> biFunction = (keY, value) -> keY + "_" + value;
        map.replaceAll(biFunction);
        String result = map.computeIfPresent(2, biFunction);
        System.out.println("Current number: " + result);
        map.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
        System.out.println(" ");
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("School", 200);

        BiFunction<Integer, Integer, Integer> function = (oldValue, newValue) -> oldValue - newValue;
        int newPrice = map1.merge("School", 50, function);
        System.out.println("New price " + newPrice);
        map1.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
        System.out.println();

        int newP = map1.merge("Shirt", 500, function);
        System.out.println("Новое значение: " + newP);
        map1.merge("Shirt", 200, function);
        map1.forEach((s, integer) -> System.out.println("Значение после merge на этот ключ: " + s + ": " + integer));

    }

}
