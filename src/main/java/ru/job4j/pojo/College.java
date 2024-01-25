package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Pozharov Aleksandr Nikolaevich");
        student.setGroup("GF-2");
        student.setDateOfAdmission("01.09.2024");
        System.out.println("Студент " + student.getFullName()
                + " из группы " + student.getGroup() + " поступил "
                + student.getDateOfAdmission());
    }
}
