package ru.job4j.odd.srp.repot;

import ru.job4j.odd.srp.model.Employee;

import java.util.function.Predicate;

public interface Report {
    String generate(Predicate<Employee> predicate);
}
