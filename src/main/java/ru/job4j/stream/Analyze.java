package ru.job4j.stream;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * получает статистику по аттестатам.
 */
public class Analyze {
    /**
     * вычисляет общий средний балл.
     * flatMap - для преобразования в поток объектов Subject;
     * * mapToInt - для преобразования в поток оценок
     * Операция mapToInt возвращает новый stream(содержащим только int).
     * Операция применяет функцию, переданную в параметр, к каждому элементу stream-а.В результате mapToInt возвращает stream, содержащий поток оценок ученика
     * average() для расчета среднего бала по предмету;
        *Операция вычисляет среднее значение элементов из stream-а типа IntStream. Она возвращает объект типа OptionalDouble.
     * orElse() позволяет определить альтернативное значение, которое будет возвращаться, если Optional не получит из потока какого-нибудь значения:
     * @param stream
     * @return
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(subject -> subject.getSubjects().stream())
                .mapToInt(score -> score.getScore())
                .average()
                .orElse(0);
    }

    /**
     * вычисляет средний балл по каждому предмету.
     * @param stream
     * @return
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(s -> new Tuple(s.getName(), s.getSubjects().stream()))
                .mapToInt()
                .average()
                .stream().collect(Collectors.toList());

    }

    /**
     * вычисляет средний балл по каждому ученику.
     * flatMap - для преобразования в поток объектов Subject;
     *
     * @param stream
     * @return
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(subject -> subject.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new, Collectors.averagingDouble()))
    }

    /**
     * возвращает лучшего ученика. Лучшим считается ученик с наибольшим баллом по всем предметам.
     * @param stream
     * @return
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return null;
    }

    /**
     * возвращает предмет с наибольшим баллом для всех студентов.
     * Возвращает объект Tuple (имя предмета, сумма баллов каждого ученика по этому предмету)
     * @param stream
     * @return
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return null;
    }

}
