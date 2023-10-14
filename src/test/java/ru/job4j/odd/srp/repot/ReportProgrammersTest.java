package ru.job4j.odd.srp.repot;

import org.junit.jupiter.api.Test;
import ru.job4j.odd.srp.formatter.DateTimeParser;
import ru.job4j.odd.srp.formatter.ReportDateTimeParser;
import ru.job4j.odd.srp.model.Employee;
import ru.job4j.odd.srp.store.MemStore;
import ru.job4j.odd.srp.store.Store;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ReportProgrammersTest {

    @Test
    void whenReportProgrammers() {
        Calendar calendar = Calendar.getInstance();
        Employee employee = new Employee("Vera", calendar, calendar, 40000);
        Employee employee2 = new Employee("Ola", calendar, calendar, 64000);
        MemStore store = new MemStore();
        store.add(employee);
        store.add(employee2);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        ReportProgrammers reportProgrammers = new ReportProgrammers(store, parser);
        StringBuilder expected = new StringBuilder();
        expected.append("Name; Hired; Fired; Salary;")
                .append(employee.getName()).append(";")
                .append(employee.getFired()).append(";")
                .append(employee.getHired()).append(";")
                .append(employee.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(reportProgrammers.generate(tr -> true)).isEqualTo(expected.toString());
    }

}