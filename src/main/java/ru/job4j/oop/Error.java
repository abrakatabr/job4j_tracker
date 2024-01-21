package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Активность: " + active);
        System.out.println("Код ошибки: " + status);
        System.out.println("Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error error1 = new Error();
        Error error2 = new Error(true, 2, "Общая ошибка сигнала");
        Error error3 = new Error(false, 6, "Ошибка алгоритма");
        error1.printInfo();
        error2.printInfo();
        error3.printInfo();
    }
}
