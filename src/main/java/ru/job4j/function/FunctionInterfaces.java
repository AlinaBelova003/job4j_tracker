package ru.job4j.function;

import java.util.*;
import java.util.function.*;

public class FunctionInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biCon = (i, s) -> System.out.println(map.put(i, s));
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");

        BiPredicate<Integer, String> biPred = (i, s) -> i % 2 == 0 || s.length() == 4;
        for (Integer i : map.keySet()) {
            biPred.test(i, map.get(i));
            }

        Supplier<List<String>> sup = () -> new ArrayList<>();
        List<String> strings = sup.get();
        for (String s : strings) {
            System.out.println(s);
        }

        Consumer<String> con = (s) -> System.out.println(s);
        Function<String, String> func = (s) -> s.toUpperCase();
        for (String s : strings) {
            con.accept(func.apply(s));
            System.out.println(s.toUpperCase());
        }
    }
}
