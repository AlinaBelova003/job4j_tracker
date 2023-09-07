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
            label.add(new Label(pupil.name(), totalScore / totalCountSubjects));
        }
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
                map.merge(subject.nameSubject(), subject.score(), Integer::sum);
            }

        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String nameSubject = entry.getKey();
                int scoreSubject = entry.getValue() / pupils.size();
                label.add(new Label(nameSubject, scoreSubject));
            }

        return label;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }

            list.add(new Label(pupil.name(), score));
        }
        list.sort(Comparator.naturalOrder());

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
        }
        list.sort(Comparator.naturalOrder());

        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {

    }
}
