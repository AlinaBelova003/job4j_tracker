package ru.job4j.odd.srp.repot;

import org.junit.jupiter.api.Test;
import ru.job4j.odd.srp.currency.Currency;
import ru.job4j.odd.srp.currency.CurrencyConverter;
import ru.job4j.odd.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.odd.srp.formatter.DateTimeParser;
import ru.job4j.odd.srp.formatter.ReportDateTimeParser;
import ru.job4j.odd.srp.model.Employee;
import ru.job4j.odd.srp.store.MemStore;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.*;

class ReportEngineAccountingTest {

    @Test
    public void whenSalaryRUBInCurrencyUSD() {
        MemStore store = new MemStore();
        Calendar calendar = Calendar.getInstance();
        Employee employee = new Employee("Vera", calendar, calendar, 38000);
        store.add(employee);

        InMemoryCurrencyConverter converter = new InMemoryCurrencyConverter();
        ReportEngineAccounting report = new ReportEngineAccounting(store, converter);

        StringBuilder expected = new StringBuilder();
        expected.append("Name; Salary;").append(System.lineSeparator())
                .append(employee.getName()).append(" ")
                .append(615.6)
                .append(System.lineSeparator());

        assertThat(report.generate(pred -> true)).isEqualTo(expected.toString());
    }
}