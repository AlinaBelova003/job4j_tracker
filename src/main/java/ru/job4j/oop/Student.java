package ru.job4j.oop;

public class Student {
    public void music() {
        System.out.println("Tra tra tra");
    }

    public void song() {
        System.out.println("I believe I can try ");
    }

    public static void main(String[] args) {
        Student petr = new Student();
        petr.music();
        petr.music();
        petr.music();
        petr.song();
        petr.song();
        petr.song();
    }
}
