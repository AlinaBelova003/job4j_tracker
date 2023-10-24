package ru.job4j.odd.srp.currency;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InMemoryCurrencyConverterTest {

    @Test
    void whenConverterRubThenEuro() {
        InMemoryCurrencyConverter converter = new InMemoryCurrencyConverter();
        Currency sours = Currency.RUB;
        double soursValue = 1000;
        Currency target = Currency.EUR;
        double result = converter.currency(sours, soursValue, target);
        double expected = 16.6;
        assertThat(result).isEqualTo(expected);
    }

}