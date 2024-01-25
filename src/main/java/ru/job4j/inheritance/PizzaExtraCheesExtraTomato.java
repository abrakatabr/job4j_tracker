package ru.job4j.inheritance;

public class PizzaExtraCheesExtraTomato extends PizzaExtraChees {
    @Override
    public String name() {
        return super.name() + " + extra tomato";
    }
}
