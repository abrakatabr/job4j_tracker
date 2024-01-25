package ru.job4j.inheritance;

public class PizzaExtraChees extends Pizza {
    public String name() {
        return super.name() + " + extra chees";
    }
}
