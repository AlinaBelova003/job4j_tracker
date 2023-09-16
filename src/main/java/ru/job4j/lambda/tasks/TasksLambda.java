package ru.job4j.lambda.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class TasksLambda {
    public static void main(String[] args) {
        List<Integer> list = List.of(12, 47, 35, 84, 89, 0, 12, 96);
        Predicate<Integer> predicate = num -> num > 50;
        List<Integer> filterList = filter(list, predicate);
        System.out.println(filterList);
        System.out.println(" ");

        Supplier<String> supplier = () -> {
            String formatRandom = "vjktnvirhnjnjfnhir49894fnjnkd";
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                int index = (int) (Math.random() * formatRandom.length());
                stringBuilder.append(formatRandom.charAt(index));
                System.out.println(stringBuilder);
            }
            return stringBuilder.toString();
        };

        List<String> password = generatePassword(8, supplier);
        System.out.println(password);
    }

    public static List<Integer> filter(List<Integer> list, Predicate<Integer> pred) {
       List<Integer> listFilter = new ArrayList<>();
       for (Integer i : list) {
           if (pred.test(i)) {
               listFilter.add(i);
           }
       }
        return listFilter;
    }

    public static List<String> generatePassword(int count, Supplier supplier) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String password = (String) supplier.get();
            list.add(password);
        }
        return list;
    }

}
