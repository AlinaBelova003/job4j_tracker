package ru.job4j.odd.tdd;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.Calendar;
import java.util.List;
@Disabled("Тесты отключены. Удалить аннотацию после реализации всех методов по заданию.")
class Cinema3DTest {
    /**
     * данный тест проверяет корректность работы метода buy в кинотеатре при покупке билета с использованием аккаунта пользователя.
     */
    @Test
    public void whenBuyThenGetTicket() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar calendar = Calendar.getInstance();
        Ticket result = cinema.buy(account, 2, 4, calendar);
        assertThat(result).isEqualTo(new Ticket3D());
    }

    /**
     * Проверка, что при указании отрицательного место выпадет исключение
     */
    @Test
    public void whenBuyOnInvalidRowThenGetException() {
        Cinema cinema = new Cinema3D();
        Account account = new AccountCinema();
        Calendar calendar = Calendar.getInstance();
        assertThatThrownBy(() -> cinema.buy(account, -1, 7, calendar))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * Проверка, что при не соблюдение рядов в диапазоне от 1 до 30 выпадет исключение
     */
    @Test
    public void whenBuyColumnBetween1And30ThenGetException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar calendar = Calendar.getInstance();
        Ticket result = cinema.buy(account, 2, 31, calendar);
        Assertions.assertThat(result).isInstanceOf(NullPointerException.class);
    }

    /**
     * Проверка, что сеанс правильно найден по предикату
     */
    @Test
    void whenAddSessionThenExistBetweenAllSessions() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        List<Session> result = cinema.find(ses -> true);
        assertThat(result).contains(session);
    }

    /**
     * Проверка, что если сеанс не найден по предикату, то возвращается пустое значение
     */
    @Test
    public void whenAddSessionThenResultNull() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        List<Session> result = cinema.find(session1 -> false);
        Assertions.assertThat(result).contains(null);
    }
}