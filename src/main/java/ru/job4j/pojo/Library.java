package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book demons = new Book("Бесы", 320);
        Book road = new Book("Дорога", 276);
        Book carrie = new Book("Кэрри", 302);
        Book cleanCode = new Book("Clean code", 428);
        Book[] books = new Book[4];
        books[0] = demons;
        books[1] = road;
        books[2] = carrie;
        books[3] = cleanCode;
        System.out.println("Выводим созданный массив на косоль:");
        for (Book a : books) {
            System.out.println(a.getName() + " - " + a.getCountOfPages());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println("Меняем местами по индексам 0 и 3:");
        for (Book a : books) {
            System.out.println(a.getName() + " - " + a.getCountOfPages());
        }
        System.out.println("Выводим с именем Clean code");
        for (Book a : books) {
            if ("Clean code".equals(a.getName())) {
                System.out.println(a.getName() + " - " + a.getCountOfPages());
            }
        }
    }
}
