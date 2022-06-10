package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {
    /**
     * Метод преобразует матрицу в список чисел.
     * Stream.of - Метод принимает массив объектов и создает на их основе стрим.
     * — flatMap()- Для преобразования и создания плоского линейного списка
     * collect - позволяет полученный результат сохранить в коллекции типа List..collect
     */
    public static List<Integer> convert(Integer[][] matrix) {
        return Stream.of(matrix)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}
