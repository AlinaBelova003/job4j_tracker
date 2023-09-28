package ru.job4j.odd.srp.object;

import ru.job4j.odd.srp.object.Customer;

/**
 * Это неправильный пример, нарушающий spr
 * Т.к В классе ответственном за заказы происходит ещё и создание объекта Customer
 */
public class Order {
    Customer customer;

    public Order() {
        customer = new Customer();
    }

}
