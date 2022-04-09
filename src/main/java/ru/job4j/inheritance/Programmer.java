package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String language;

    public Programmer(String name, String surname, String education, int birthday, String imagination, String language) {
        super(name, surname, education, birthday, imagination);
        this.language = language;
    }

    public String fantasize() {
        String programmerFantasize = super.fantasize();
        return programmerFantasize;
    }

    public String writing() {
        System.out.println("Программист пишет код на языке " + language);
        return language;
    }
}
