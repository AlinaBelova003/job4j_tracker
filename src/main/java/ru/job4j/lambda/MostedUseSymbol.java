package ru.job4j.lambda;

import java.util.HashMap;
import java.util.Map;

public class MostedUseSymbol {
    public static void main(String[] args) {
        String input = "Как же долго я усваиваю материал по Java".replaceAll(" ", "");
        Map<Character, Integer> map = new HashMap<>();
        for (Character character : input.toCharArray()) {
            map.computeIfPresent(character, (key, value) -> value + 1);
        }
        int max = 0;
        char result = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        System.out.println("Больше всего символов: " + result);
    }
}
