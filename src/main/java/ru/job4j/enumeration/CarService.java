package ru.job4j.enumeration;

public class CarService {

    public static void main(String[] args) {
        Status toyota = Status.FINISHED;
        Status volvo = Status.WAITING;
        System.out.println("Статус Toyota: " + toyota);
        System.out.println("Статус Volvo: " + volvo);
        Order order = new Order(1, "BMW", Status.ACCEPTED);
        System.out.println("Заказ-наряд №" + order.getNumber() + " на автомобиль: " + order.getCar()
        + " статус ремонта: " + order.getStatus().getInfo());
    }
}
