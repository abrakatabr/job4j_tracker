package ru.job4j.inheritance;

public class PizzaExtraChees extends Pizza {
    @Override
    public String name() {
        return super.name() + " + extra chees";
    }
}
