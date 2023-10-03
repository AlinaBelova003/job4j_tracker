package ru.job4j.odd.srp.formatter;

import ru.job4j.odd.srp.model.Employee;
import ru.job4j.odd.srp.repot.Report;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.function.Predicate;

public class ReportDateTimeParser implements DateTimeParser<Calendar> {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    @Override
    public String parser(Calendar calendar) {
        return DATE_FORMAT.format(calendar.getTime());
    }
}
