package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает счета пользователей банковского сервиса.
 *  * @author Alex Pozharov
 *  * @version 1.0
 */
public class Account {
    /**
     * Реквизиты счета.
     */
    private String requisite;
    /**
     * Баланс счета.
     */
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод позволяет получить реквизиты счета.
     * @return возвращает реквизиты счета.
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод позовляет изменить реквизиты счета.
     * @param requisite реквизиты счета, которые
     *                  требуется установить.
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод позволяет получить баланс счета.
     * @return возвращает баланс счета.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод позволяет изменить баланс счета.
     * @param balance баланс счета, который
     *                требуется установить.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределенный метод класса Object для
     * сравнения объектов данного класса.
     * @param o сравниваемый объект.
     * @return возвращает true, если ссылки объекта данного
     * класса и сравниваемого объекта одинаковые, а так же,
     * если реквизиты счета объекта данного класса и сравниваемого объекта
     * одинаковы. Возвращает false, если сравниваемый объект не имеет
     * ссылки, если класс объекта не совпадает с классом данного
     * объека, и если реквизиты счета объектов не совпадают.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределеный метод класса Object
     * @return возвращает хэш-код длиной 32 бита, сгенерированный
     * на основе реквизитов счета.
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
