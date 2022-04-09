package ru.job4j.inheritance;

public class Builder extends Engineer {
    private String tool;

    public Builder(String name, String surname, String education, int birthday, String imagination, String tool) {
        super(name, surname, education, birthday, imagination);
        this.tool = tool;
    }

    public String fantasize() {
        String builderFantasize = super.fantasize();
        return builderFantasize;
    }

    public String workingElectricity() {
        String electricity = "Этот строитель часто решает проблемы с электричеством";
        return electricity;
    }
}
