package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUl {
    public static void main(String[] args) {
        Item item = new Item();
        LocalDateTime created = item.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd - MMMM - EEEE - yyy - HH: mm : ss");
        String localDateTimeFormatter = created.format(formatter);
        System.out.println(localDateTimeFormatter);
    }
}
