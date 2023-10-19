package ru.job4j.odd.srp.hr;

import ru.job4j.odd.srp.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortSalary {

    public static List<Employee> sortSalaryReversed(List<Employee> employee) {
        return employee.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());
    }

}
