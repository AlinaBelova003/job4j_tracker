package ru.job4j.inheritance;

public class Doctor extends Profession {
    private String oathHippocratic;

    public Doctor(String name, String surname, String education, int birthday, String oathHippocratic) {
        super(name, surname, education, birthday);
        this.oathHippocratic = oathHippocratic;
    }

    public String promise() {
        System.out.println("Главное правило клятвы Гиппократа - не навреди");
        return oathHippocratic;
    }
}
