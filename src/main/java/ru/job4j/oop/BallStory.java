package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();
        Ball ball = new Ball();
        System.out.println("История колобка:");
        System.out.println("Колобок убежал и встретил зайца.");
        hare.tryEat(ball);
        System.out.println("Колобок встретил волка.");
        wolf.tryEat(ball);
        System.out.println("Колобок встретил лису.");
        fox.tryEat(ball);
        System.out.println("Конец.");
    }
}
