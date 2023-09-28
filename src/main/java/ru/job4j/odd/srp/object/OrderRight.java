package ru.job4j.odd.srp.object;

/**
 * Это правильный пример.
 * Теперь класс Order принимает уже созданный объект Customer в конструкторе,
 * а создание и инициализация объекта Customer происходит в отдельном классе
 * Таким образом, каждый класс отвечает только за один важный аспект работы в системе, а требуемые объекты создаются и передаются через внедрение зависимостей.
 */
public class OrderRight {

    private Customer customer;

    public OrderRight(Customer customer) {
        this.customer = customer;
    }
}
