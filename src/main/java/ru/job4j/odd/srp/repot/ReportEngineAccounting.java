package ru.job4j.odd.srp.repot;

import ru.job4j.odd.srp.currency.CurrencyConverter;
import ru.job4j.odd.srp.model.Employee;
import ru.job4j.odd.srp.store.Store;


import java.util.Currency;
import java.util.function.Predicate;

public class ReportEngineAccounting implements Report {

    private CurrencyConverter currency;
    private Store store;

    /**
     * Передача интерфейса CurrencyConverter в конструктор позволяет нам:
     * Не создавать объект, а сразу принимать и преобразовывать валюты
     * Замена на другую реализацию в будущем
     */
    public ReportEngineAccounting(Store store, CurrencyConverter currency) {
        this.store = store;
        this.currency = currency;
    }

    @Override
    public String generate(Predicate<Employee> predicate) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name; Salary;").append(System.lineSeparator());

        for (Employee employee : store.findBy(predicate)) {
            stringBuilder.append(employee.getName()).append(" ")
                    .append(currency.currency(ru.job4j.odd.srp.currency.Currency.RUB, employee.getSalary(), ru.job4j.odd.srp.currency.Currency.USD))
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
