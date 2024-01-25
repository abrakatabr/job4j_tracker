package ru.job4j.inheritance;

public class PizzaShop {
    public static void main(String[] args) {
        Pizza pizza = new Pizza();
        PizzaExtraChees pizzaExtraChees = new PizzaExtraChees();
        PizzaExtraCheesExtraTomato pizzaExtraCheesExtraTomato = new PizzaExtraCheesExtraTomato();
        System.out.println(pizza.name());
        System.out.println(pizzaExtraChees.name());
        System.out.println(pizzaExtraCheesExtraTomato.name());
    }
}
