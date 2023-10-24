package ru.job4j.odd.srp.repot;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.odd.srp.formatter.DateTimeParser;
import ru.job4j.odd.srp.formatter.ReportDateTimeParser;
import ru.job4j.odd.srp.model.Employee;
import ru.job4j.odd.srp.store.MemStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ReportEngineTest {

    @Test
    void whenReportProgrammers() {
        Calendar calendar = Calendar.getInstance();
        Employee employee = new Employee("Vera", calendar, calendar, 40000);
        MemStore store = new MemStore();
        store.add(employee);

        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        ReportEngine reportEngine = new ReportEngine(store, parser);
        StringBuilder expected = new StringBuilder();
        expected.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(employee.getName()).append(";")
                .append(parser.parser(employee.getFired())).append(";")
                .append(parser.parser(employee.getHired())).append(";")
                .append(employee.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(reportEngine.generate(tr -> true)).isEqualTo(expected.toString());
    }

}