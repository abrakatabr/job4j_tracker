package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описываает работу банковского сервиса с возможностью
 * добавления и удаления анкет пользователей, поиска пользователей и
 * перевода денежных средств между счетами пользователей.
 * @author Alex Pozharov
 * @version 1.0
 */
public class BankService {
    /**
     * Хоранение данных о пользователе и его счетах осуществляется
     * в коллекции типа HashMap в виде пары ключ-значение, где ключ -
     * анкета пользователя, а значение - Коллекция типа List, заполненная
     * счетами этого пользователя.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод позволяет добавить в коллекцию хранения данных анкету
     * нового пользователя, и соответствующую ей коллекцию счетов
     * пользователя, если такого пользователя нет в коллекции.
     * @param user анкета пользователя, которая добавляется в коллекцию.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод позволяет удалить анкету пользователя и соответствующие
     * ей счета из коллекции хранения данных.
     * @param passport паспортные данные анкеты пользователя,
     *                 которую требуется удалить.
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод позваляет добавить новый счет пользователя.
     * @param passport паспортные данные пользователя, которому
     *                 требуется добавить счет.
     * @param account добавляемый счет.
     */
    public void addAccount(String passport, Account account) {
        User userFound = findByPassport(passport);
        if (userFound != null) {
            List<Account> accounts = users.get(userFound);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод, реализующий поиск анкеты пользователя по паспотным данным.
     * @param passport паспортные данные пользователя, анкету которого
     *                 требуется найти.
     * @return возвращает анкету пользователя. Если анкета в коллекции
     * хранения данных не найдена - возвращает null.
     */
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

    /**
     * Метод, реализующий поиск счета пользователя.
     * @param passport паспортные данные пользователя,
     *                 чей счет требуется найти.
     * @param requisite реквизиты счета.
     * @return возвращает счет пользователя (ссылку на объект класса Account).
     * Если счет не найден - возвращает null.
     */
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

    /**
     * Метод, реализующий перевод денежных средств между счетами пользователей.
     * @param sourcePassport паспортные данные пользователя, чей счет
     *                       является источником перевода.
     * @param sourceRequisite реквизиты счета-источника.
     * @param destinationPassport паспортные данные польщователя, держателя
     *                            счета, на который назначается перевод.
     * @param destinationRequisite реквизиты счета, на который назначается перевод.
     * @param amount сумма перевода.
     * @return возвращает true, если перевод денежных средств произведен успешно.
     * Возвращает false, если счета получателя или источника не существует,
     * а так же если сумма перевода больше чем баланс счета источника платежа.
     */
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

    /**
     * Метод позволяет получить коллекцию счетов пользвоателя.
     * @param user принимет на вход анкету пользователя.
     * @return возвзращает коллекцию счетов пользваотеля.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
