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
        users.remove(new User(passport, ""));
    }

    public void addAccount(String passport, Account account) {
        User userFound = findByPassport(passport);
        List<Account> accounts = new ArrayList<>();
        if (userFound != null) {
            accounts = users.get(userFound);
        }
        if (!accounts.contains(account)) {
            accounts.add(account);
        }
    }

    public User findByPassport(String passport) {
        User userSearch = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                userSearch = user;
                break;
            }
        }
        return userSearch;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account accountSearch = null;
        User userFound = findByPassport(passport);
        if (userFound != null) {
            List<Account> accounts = users.get(userFound);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    accountSearch = account;
                    break;
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
