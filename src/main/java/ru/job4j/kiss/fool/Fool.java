package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {
    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        int startAt = 1;
        var io = new Scanner(System.in);

        while (startAt < 100) {
            System.out.println(Logic.checkAnswer(startAt++));
            String answer = Logic.checkAnswer(startAt);
            if (!answer.equals(io.nextLine())) {
                System.out.println("Ошибка. Начинай снова.");
                startAt = 0;
            }
            startAt++;
        }
    }

    static class Logic {
        /**
         * Этот код анализирует ответы пользователя
         *
         * @param startAt счетчик
         * @return либо String надпись, либо число
         */
        public static String checkAnswer(int startAt) {
            String value;
            if (startAt % 3 == 0 && startAt % 5 == 0) {
                value = "FizzBuzz";
            } else if (startAt % 3 == 0) {
                value = "Fizz";
            } else if (startAt % 5 == 0) {
                value = "Buzz";
            } else {
                value = String.valueOf(startAt);
            }
            return value;
        }
    }
}
