package ru.job4j.inheritance;

public class TextReport {
    private String name;
    private String body;

    public String generate(String name, String body) {
        return name + System.lineSeparator() + body;
    }
}
