package ru.job4j.odd.srp.hr;

import ru.job4j.odd.srp.model.Employee;
import ru.job4j.odd.srp.repot.Report;
import ru.job4j.odd.srp.store.Store;

import java.util.function.Predicate;

public class ReportEngineHR implements Report {
    private final Store store;

    public ReportEngineHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> predicate) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name; Salary");
        for (Employee employee : store.findBy(predicate)) {
            stringBuilder.append(employee.getName())
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

}
