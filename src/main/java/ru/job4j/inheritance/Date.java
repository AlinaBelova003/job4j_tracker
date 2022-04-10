package ru.job4j.inheritance;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Date {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println("Текущяя дата " + localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println("Текущее время " + localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Текущее время и дата " + localDateTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
        String localDateTimeFormatter = localDateTime.format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + localDateTimeFormatter);
    }
}
