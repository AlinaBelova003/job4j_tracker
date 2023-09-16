package ru.job4j.odd.tdd;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class Cinema3D implements Cinema {
    @Override
    public List<Session> find(Predicate<Session> predicate) {
        return null;
    }

    @Override
    public Ticket buy(Account account, int row, int column, Calendar calendar) {
        return null;
    }

    @Override
    public void add(Session session) {

    }
}
