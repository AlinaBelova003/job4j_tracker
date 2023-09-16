package ru.job4j.condition;

public class SxMax {

    public static int max(int left, int right) {
        return Math.max(left, right);
    }

    public static int method(int first, int second, int third, int four) {
        return max(
                max(first, second),
                max(third, four)
        );
    }
}
