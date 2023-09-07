package ru.job4j.hmap;

import ru.job4j.inheritance.Pizza;

import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnalyzeByMap {
    /**
     * Находит среднее значение балов всех предметов у всех учеников
     * @param pupils список учеников по которому проходим
     * @return среднее double значение
     */
    public static double averageScore(List<Pupil> pupils) {
        double totalScore = 0;
        double totalCountSubjects = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
                totalCountSubjects++;
            }
            System.out.println("Общая сумма балов учеников по всем предметам: " + totalScore);
            System.out.println("Средний балл: " + totalScore / totalCountSubjects);
        }
        return totalScore / totalCountSubjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> label = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double totalScore = 0;
            double totalCountSubjects = pupil.subjects().size();
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            System.out.println("Общий бал ученика: " + pupil.name() + " " + totalScore);
            label.add(new Label(pupil.name(), totalScore / totalCountSubjects));
        }
        System.out.println("Средний балл для каждого ученика: " + label);

        return label;
    }

    /**
     * Нахождение среднего значения за предмет
     * Почему используем map?
     * Создается пустая LinkedHashMap map, которая будет использоваться для хранения суммы баллов по каждому предмету, позволяет легко обновлять значения
     * Создается пустой ArrayList label, который будет использоваться для хранения объектов Label.
     */
    public static List<Label> averageScoreBySubjects(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> label = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int map1 =  map.merge(subject.nameSubject(), subject.score(), Integer::sum);
                System.out.println("Нумерование каждого предмета при вхождение одинаково ключа: " + subject.nameSubject() + "-" + map1);
            }

        }
        System.out.println("Общий бал предмета " + map);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String nameSubject = entry.getKey();
                int scoreSubject = entry.getValue() / pupils.size();
                label.add(new Label(nameSubject, scoreSubject));
            }

        System.out.println("Среднее значение каждого предмета: " + label);
        return label;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            System.out.println("Возврат общего бала " + score);
            list.add(new Label(pupil.name(), score));
            list.sort(Comparator.naturalOrder());
        }
        System.out.println("Ученик с наибольшим балом: " + list.get(list.size() -  1));
        return list.get(list.size() - 1);
    }

    /**
     * В мапе мы собираем общую суму балов предметов. Удобное обновление по ключю
     * В List собираем значения из мапы и сортируем по самому большому баллу предмета
     * @param pupils список учеников
     * @return предмет с наибольшим балов всех учеников
     */
    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.nameSubject(), subject.score(), Integer::sum);
            }
        }
        for (Map.Entry<String, Integer> mapValue : map.entrySet()) {
            String nameSubject = mapValue.getKey();
            int scoreSubject = mapValue.getValue();
            list.add(new Label(nameSubject, scoreSubject));
            list.sort(Comparator.naturalOrder());
        }

        System.out.println(list.get(list.size() - 1));
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        List<Subject> list1 = List.of(new Subject("Math", 90), new Subject("English", 87), new Subject("Fiz", 75));
        Pupil pupil = new Pupil("Ivanov", list1);

        List<Subject> subjects2 = Arrays.asList(new Subject("Math", 95), new Subject("English", 88), new Subject("Fiz", 81));
        Pupil pupil2 = new Pupil("Bob", subjects2);

        List<Subject> subjects3 = Arrays.asList(new Subject("Math", 92), new Subject("English", 90));
        Pupil pupil3 = new Pupil("Carol", subjects3);

        List<Pupil> pupils = List.of(pupil, pupil2, pupil3);
        averageScore(pupils);
        System.out.println(" ");

        averageScoreByPupil(pupils);
        System.out.println(" ");

        averageScoreBySubjects(pupils);
        System.out.println(" ");

        bestStudent(pupils);
        System.out.println(" ");

        bestSubject(pupils);

    }
}
