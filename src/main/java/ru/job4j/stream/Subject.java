package ru.job4j.stream;

/**
 * описывает школьный предмет и аттестационный балл ученика.
 */
public class Subject {
    private String name;
    private int score;

    Subject(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
