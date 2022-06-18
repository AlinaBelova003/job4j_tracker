package ru.job4j.stream;

import java.util.Comparator;
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
        return stream.map(s -> new Tuple(s.getName(), s.getSubjects().stream()
                        .mapToInt(Subject::getScore)
                        .average()
                        .orElse(0)
                ))
                .collect(Collectors.toList());
    }

    /**
     * вычисляет средний балл по каждому ученику.
     * flatMap - для преобразования в поток объектов Subject;
     * collect.groupingBy - группируем данные имя
     * Используем конструктор для хранения пары ключ-значение в порядке поступления
     * Метод коллекторов averagingDouble используется для нахождения среднего значения double, переданного в параметрах
     * entrySet()- возвращает Set, содержащий записи Map и открывает поток
     * полученный поток с помощью map() преобразуем в поток объектов класса Tuple, внутри метода создаваём эти объекты
     * в конструктор мы передаём параметры с помощью методов getKey()- возвращяет ключ записи
     * и getValue() - возвращает значение записи в Мaр
     * все соберем в коллекцию List.
     *
     *
     * @param stream
     * @return
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(subject -> subject.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(value -> new Tuple(value.getKey(), value.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * возвращает лучшего ученика. Лучшим считается ученик с наибольшим баллом по всем предметам.
     * @param stream
     * @return
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(s -> new Tuple(s.getName(), s.getSubjects().stream()
                        .mapToInt(Subject::getScore)
                        .sum()
                ))
                .max(Comparator.comparing(Tuple::))
                .orElse(0);
    }

    /**
     * возвращает предмет с наибольшим баллом для всех студентов.
     * Возвращает объект Tuple (имя предмета, сумма баллов каждого ученика по этому предмету)
     * @param stream
     * @return
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(s -> s.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        LinkedHashMap::new,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(value -> new Tuple(value.getKey(), value.getValue()))
                .max(Comparator.comparing(Tuple::))
                .orElse(0);
    }
}
