package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    /**
     * Поиск аккаунта и помощью Optional класса, который безопасно обрабатывает null-значения
     * Optional.empty = Этот метод создает пустой класс Optional.
     * Optional.of — возвращает Optional-объект.Этот метод нужно использовать только тогда, когда вы уверены что значение не является null
     */
    public Optional<Student> findByAccount(String account) {
        Optional<Student> rsl = Optional.empty();
        for (Student s : students.keySet()) {
            if (account.equals(s.getAccount())) {
                rsl = Optional.of(s);
                break;
            }
        }
        return rsl;
    }

    /**
     * Для получения значения из Optional используется метод Optional.get, но он является небезопасным и может бросить NoSuchElementException
     * Метод Optional.get лучше использовать в паре с Optional.isPresent чтобы предотвратить исключения.
     * isPresent() - Этот метод возвращает ответ, существует ли искомый объект или нет, в виде Boolean.
     * Если существует, то получаем его значение через get
     */
    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Subject> rsl = Optional.empty();
        Optional<Student> s = findByAccount(account);
        if (s.isPresent()) {
            Set<Subject> subjects = students.get(s.get());
            for (Subject subj : subjects) {
                if (name.equals(subj.getName())) {
                    rsl = Optional.of(subj);
                    break;
                }
            }
        }
        return rsl;
    }
}

