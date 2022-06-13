package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу основных действий банковской системы: добавление и удаление пользователя, добавление счета
 * и перевод наличных с одного счета на другой.
 * @author Alina Belova
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение задания осуществляется в коллекции MAP(ключ-значение) типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему. Используем упрощенный метод проверки putIfAbsent, если  пользователя
     * в системе нет, то добавляем его в коллекцию.
     * @param user пользователь, которого мы проверяем и добавляем.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Добавление нового счета
     * Метод принимает на вход данные паспорта и аккаунта.
     * Находим пользователя по паспорту, получаем список всех счетов пользователя,если таких данных пасспорта нет
     * и пользователь не имеет такого счета, то добавляем счет в аккаунт.
     * @param passport данные паспорта
     * @param account аккаунт, который содержит счета пользователя.
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent() && !users.get(user).contains(account)) {
           users.get(user.get()).add(account);
        }

    }

    /**
     * Поиск и получение пользователя по данным паспорта.
     * Проходим по циклу из значений ключей. Если вводимые данные есть в системе пользователя, то выводим пользователя
     * @param passport задача, которую мы ищем
     * @return возвращяет пользователя, если его нет, то null
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                        .stream()
                        .filter(user1 -> user1.getPassport().equals(passport))
                        .findFirst();
    }

    /**
     * Поиск пользователя по реквизитам.
     * Находим пользователя по паспорту, получаем список его счетов.
     * @param passport задача, по которой мы ищем паспорт пользователя
     * @param requisite задача, которую мы сравниваем с имеющимися реквизитами
     * @return если такой счет в коллекции есть возвращяем номер счета, если нет, то null
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(account1 -> account1.getRequisite().equals(requisite))
                    .findFirst();
        }
        return user.get();
    }

    /**
     * Метод перечисляет деньги с одного счета на другой.
     * Извлекаем счёт отправителя и получателя из паспорта и реквизитов и кладём их в переменные.
     * Проверяете найден ли каждый счёт (на null) и достаточно ли денег для перевода
     * @param srcPassport пасспорт отправителя
     * @param srcRequisite реквизиты отправителя
     * @param destPassport пасспорт получателя
     * @param destRequisite реквизиты получателя
     * @param amount деньги на счету
     * @return Если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят),
     * то метод возвращяет false. Если хватает, то true.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {

        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        boolean rsl = false;
        if (srcAccount.isPresent() && destAccount.isPresent() && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
