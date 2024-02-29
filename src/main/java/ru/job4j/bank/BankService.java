package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(String passport) {
        users.remove(findByPassport(passport));
    }

    public void addAccount(String passport, Account account) {
        User userFound = findByPassport(passport);
        if (userFound != null && !users.get(userFound).contains(account)) {
            users.get(userFound).add(account);
        }
    }

    public User findByPassport(String passport) {
        User userSearch = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                userSearch = user;
            }
        }
        return userSearch;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account accountSearch = null;
        if (findByPassport(passport) != null) {
            List<Account> accounts = users.get(findByPassport(passport));
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    accountSearch = account;
                }
            }
        }
        return accountSearch;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account source = findByRequisite(sourcePassport, sourceRequisite);
        Account destination = findByRequisite(destinationPassport, destinationRequisite);
        if (source != null && destination != null && amount <= source.getBalance()) {
            source.setBalance(source.getBalance() - amount);
            destination.setBalance(destination.getBalance() + amount);
            result = true;
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
