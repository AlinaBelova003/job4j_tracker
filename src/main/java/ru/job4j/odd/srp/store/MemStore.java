package ru.job4j.odd.srp.store;

import ru.job4j.odd.srp.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MemStore implements Store {
    private final List<Employee> employeeList = new ArrayList<>();

    @Override
    public void add(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public List<Employee> findBy(Predicate<Employee> predicate) {
        return employeeList.stream().filter(predicate).collect(Collectors.toList());
    }
}
