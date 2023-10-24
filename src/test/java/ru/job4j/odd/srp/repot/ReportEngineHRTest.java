package ru.job4j.odd.srp.repot;

import org.junit.jupiter.api.Test;
import ru.job4j.odd.srp.formatter.DateTimeParser;
import ru.job4j.odd.srp.formatter.ReportDateTimeParser;
import ru.job4j.odd.srp.model.Employee;
import ru.job4j.odd.srp.store.MemStore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.*;

class ReportEngineHRTest {

    @Test
    public void whenSortSalaryTrue() {
        Calendar calendar = Calendar.getInstance();
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Ivan", calendar, calendar, 30000));
        employeeList.add(new Employee("Alex", calendar, calendar, 25000));
        employeeList.add(new Employee("Vladimir", calendar, calendar, 40000));

        List<Employee> expected = List.of(new Employee("Alex", calendar, calendar, 25000),
                new Employee("Ivan", calendar, calendar, 30000),
                new Employee("Vladimir", calendar, calendar, 40000));

        List<Employee> result = ReportEngineHR.sortSalary(employeeList);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenGenerateReportNameSalaryGetSalary() {
        Calendar calendar = Calendar.getInstance();
        Employee employee = new Employee("Vera", calendar, calendar, 40000);
        Employee employee2 = new Employee("Ola", calendar, calendar, 64000);
        Employee employee3 = new Employee("Dima", calendar, calendar, 94000);
        MemStore store = new MemStore();
        store.add(employee);
        store.add(employee2);
        store.add(employee3);

        DateTimeParser<Calendar> calendarDateTimeParser = new ReportDateTimeParser();
        ReportEngineHR engineHR = new ReportEngineHR(store, calendarDateTimeParser);

        StringBuilder expected = new StringBuilder();
        expected.append("Name; Salary").append(System.lineSeparator())
                .append(employee.getName()).append(" ")
                .append(employee.getSalary())
                .append(System.lineSeparator())
                .append(employee2.getName()).append(" ").append(employee2.getSalary())
                .append(System.lineSeparator())
                .append(employee3.getName()).append(" ").append(employee3.getSalary())
                .append(System.lineSeparator());

        assertThat(engineHR.generate(tr -> true)).isEqualTo(expected.toString());
    }

}
