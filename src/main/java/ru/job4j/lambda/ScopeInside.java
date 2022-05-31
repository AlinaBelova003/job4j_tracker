package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total = 0;
        for (int i = 0; i < number.length; i++) {
            int totalResult = total;
            int num = number[i];
            total = add(
                    () -> num + totalResult
            );
        }
        System.out.println(total);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}