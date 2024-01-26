package ru.job4j.pojo;

public class Book {
    private String name;
    private int countOfPages;

    public Book(String name, int countOfPages) {
        this.name = name;
        this.countOfPages = countOfPages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountOfPages() {
        return countOfPages;
    }

    public void setCountOfPages(int countOfPages) {
        this.countOfPages = countOfPages;
    }

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
            System.out.println(a.name + " - " + a.countOfPages);
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println("Меняем местами по индексам 0 и 3:");
        for (Book a : books) {
            System.out.println(a.name + " - " + a.countOfPages);
        }
        System.out.println("Выводим с именем Clean code");
        for (Book a : books) {
            if (a.name.equals("Clean code")) {
                System.out.println(a.name + " - " + a.countOfPages);
            }
        }
    }
}
