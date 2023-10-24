package ru.job4j.odd.srp.repot;

import ru.job4j.odd.srp.formatter.DateTimeParser;
import ru.job4j.odd.srp.model.Employee;
import ru.job4j.odd.srp.store.MemStore;
import ru.job4j.odd.srp.store.Store;

import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReportEngineHR implements Report {
    private final Store store;
    private DateTimeParser<Calendar> calendarDateTimeParser;

    public ReportEngineHR(Store store, DateTimeParser<Calendar> calendarDateTimeParser) {
        this.store = store;
        this.calendarDateTimeParser = calendarDateTimeParser;
    }

    public static List<Employee> sortSalary(List<Employee> employee) {
        return employee.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());
    }

    /**
     * Находит сотрудников отсортированных по зарплате и соберет их в строку
     * @param predicate сотрудники, отсортированные по какому-либо значению, которые заносятся в новый список
     * @return список сотрудников Name; Salary
     */
    @Override
    public String generate(Predicate<Employee> predicate) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name; Salary");
        stringBuilder.append(System.lineSeparator());
        List<Employee> sortedEmployeesPredicate = sortSalary(store.findBy(predicate));
        for (Employee employee : sortedEmployeesPredicate) {
            stringBuilder.append(employee.getName()).append(" ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
