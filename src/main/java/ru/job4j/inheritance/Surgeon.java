package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String scalpel;

    public Surgeon(String name, String surname, String education, int birthday, String oathHippocratic, String scalpel) {
        super(name, surname, education, birthday, oathHippocratic);
        this.scalpel = scalpel;
    }

    public String promise() {
        String promiseSurgeon = super.promise();
        return promiseSurgeon;
    }

    public String drinking() {
        return "Представителям данной професии свойственно выпивать";
    }

}
