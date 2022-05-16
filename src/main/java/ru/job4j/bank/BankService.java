package ru.job4j.bank;

import java.util.*;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user)) {
            List<Account> accounts = new ArrayList<>();
            users.put(user, accounts);
        }
    }

    public void addAccount(String passport, Account account) {

    }

    public User findByPassport(String passport) {
        User result = null;
        for (User user : users.keySet()) {
            if (users.equals(passport)) {
                result = user;
            }
        }
        return result;
    }

    public Account findByRequisite(String passport, String requisite) {
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        return rsl;
    }




}
