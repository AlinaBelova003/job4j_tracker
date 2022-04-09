package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private int money;

    public Dentist(String name, String surname, String education, int birthday, String oathHippocratic, int money) {
        super(name, surname, education, birthday, oathHippocratic);
        this.money = money;
    }

    public String promise() {
        String promiseDentist = super.promise();
        return promiseDentist;
    }

    public String salary() {
        return "Представителям данной професии свойственно зарабатывать около " + money;
    }

}
