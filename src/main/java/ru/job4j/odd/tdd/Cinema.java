package ru.job4j.odd.tdd;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public interface Cinema {

    List<Session> find(Predicate<Session> predicate);

    Ticket buy(Account account, int row, int column, Calendar calendar);

    void add(Session session);
}
