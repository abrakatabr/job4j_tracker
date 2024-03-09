package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает анкету пользователя банковского сервиса.
 * @author Alex Pozharov
 * @version 1.0
 */
public class User {
    /**
     * Серия и номер паспорта пользователя.
     */
    private String passport;
    /**
     * Имя пользователя.
     */
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод позволяет получть серию и номер паспорта пользователя.
     * @return возвращает серию и номер паспорта пользователя.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод позволяет изменить мерию и номер паспорта пользователя.
     * @param passport серия и номер паспорта пользователя, которую
     *                 требуеся установить.
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод похззволяет получить имя пользователя.
     * @return возвращает имя пользователя.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод позволяет изменить имя пользователя.
     * @param username имя пользователя, которое
     *                 требуется установить.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределенный метод класса Object для
     * сравнения объектов данного класса.
     * @param o сравниваемый объект.
     * @return возвращает true, если ссылки объекта данного
     * класса и сравниваемого объекта одинаковые, а так же,
     * если паспорта объекта данного класса и сравниваемого объекта
     * одинаковы. Возвращает false, если сравниваемый объект не имеет
     * ссылки, если класс объекта не совпадает с классом данного
     * объека, и если паспортные данные объектов не совпадают.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределеный метод класса Object
     * @return возвращает хэш-код длиной 32 бита, сгенерированный
     * на основе паспортных данных.
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
