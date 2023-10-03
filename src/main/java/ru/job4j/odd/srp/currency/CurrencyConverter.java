package ru.job4j.odd.srp.currency;

public interface CurrencyConverter {

    double currency(Currency current, double soursValue, Currency target);
}
