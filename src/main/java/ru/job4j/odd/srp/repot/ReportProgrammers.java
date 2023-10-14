package ru.job4j.odd.srp.repot;

import ru.job4j.odd.srp.formatter.DateTimeParser;
import ru.job4j.odd.srp.formatter.ReportDateTimeParser;
import ru.job4j.odd.srp.model.Employee;
import ru.job4j.odd.srp.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;

public class ReportProgrammers implements Report {

    private Store store;
    private DateTimeParser<Calendar> calendarDateTimeParser;

    public ReportProgrammers(Store store, DateTimeParser<Calendar> calendarDateTimeParser) {
        this.store = store;
        this.calendarDateTimeParser = calendarDateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> predicate) {
        return null;
    }
}
