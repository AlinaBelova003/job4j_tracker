package ru.job4j.inheritance;

public class Engineer extends Profession {
    private String imagination;

    public Engineer(String name, String surname, String education, int birthday, String imagination) {
        super(name, surname, education, birthday);
        this.imagination = imagination;
    }

    public String fantasize() {
        System.out.println("Человек это професии дружит с воображением " + imagination);
        return imagination;
    }
}
