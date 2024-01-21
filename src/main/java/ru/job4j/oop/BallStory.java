package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();
        System.out.println("История колобка:");
        System.out.println("Колобок убежал и встретил зайца.");
        hare.tryEat();
        System.out.println("Колобок встретил волка.");
        wolf.tryEat();
        System.out.println("Колобок встретил лису.");
        fox.tryEat();
        System.out.println("Конец.");
    }
}
