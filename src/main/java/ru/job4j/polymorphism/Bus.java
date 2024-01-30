package ru.job4j.polymorphism;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passengers(int numberOfPassengers) {
        System.out.println("Количество пассажиров: " + numberOfPassengers);
    }

    @Override
    public double fillUp(double amountOfFuel) {
        return 45.2 * amountOfFuel;
    }
}