package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {
    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        int startAt = 1;
        var io = new Scanner(System.in);

        while (startAt < 100) {
            if (startAt % 3 == 0 && startAt % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (startAt % 3 == 0) {
                System.out.println("Fizz");
            } else if (startAt % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(startAt);
            }
            startAt++;
            String answer = checkAnswer(io.nextLine(), startAt);
            if (answer == null) {
                System.out.println("Ошибка. Начинай снова.");
                startAt = 0;
            }
            startAt++;
        }
    }

    /**
     * Этот код анализирует ответы пользователя
     * @param answer ответы
     * @param startAt счетчик
     * @return либо String, либо число
     */
    private static String checkAnswer(String answer, int startAt) {
        if (startAt % 3 == 0 && startAt % 5 == 0) {
            return stringCheck(answer, "FizzBuzz");
        } else if (startAt % 3 == 0) {
             return stringCheck(answer, "Fizz");
        } else if (startAt % 5 == 0) {
             return stringCheck(answer, "Buzz");
        } else {
            return numberCheck(answer, String.valueOf(startAt));
        }
    }

    private static String stringCheck(String answer, String fizzBuzz) {
        return fizzBuzz.equals(answer) ? fizzBuzz : null;
    }

    private static String numberCheck(String answer, String fizzBuzz) {
        return answer.equals(fizzBuzz) ? fizzBuzz : null;
    }

}
