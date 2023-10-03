package ru.job4j.odd.srp.repot;

import ru.job4j.odd.srp.formatter.DateTimeParser;
import ru.job4j.odd.srp.model.Employee;
import ru.job4j.odd.srp.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;

public class ReportEngine implements Report {

    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public ReportEngine(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> predicate) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(predicate)) {
            text.append(employee.getName()).append(" ")
                    .append(dateTimeParser.parser(employee.getFired())).append(" ")
                    .append(dateTimeParser.parser(employee.getHired())).append(" ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
