package ru.job4j.collection;

import java.nio.charset.StandardCharsets;
import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int length1 = Math.min(left.length(), right.length());
        for (int i = 0; i < length1; i++) {
            if (left.charAt(i) == right.charAt(i)) {
                rsl = Character.compare(left.charAt(i), right.charAt(i));
            } else if (rsl != 0) {
               rsl = length1;
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}
