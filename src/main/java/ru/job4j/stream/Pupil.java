package ru.job4j.stream;

import java.util.List;

/**
 * Описание ученика и его учебных предметов
 */
public class Pupil {
    private String name;
    private List<Subject> subjects;

    Pupil(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}
