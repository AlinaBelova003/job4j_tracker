package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFIO("Belova Alina Maksimovna");
        student.setGroup("Java");
        student.setDateOfReceip(" 16 февраля");
        System.out.println(student.getFIO() + " поступила на " + student.getGroup() + student.getDateOfReceip());
    }
}
