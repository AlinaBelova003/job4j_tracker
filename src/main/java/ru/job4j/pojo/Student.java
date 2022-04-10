package ru.job4j.pojo;

public class Student {
    private String fIO;
    private String group;
    private String dateOfReceip;

    public String getFIO() {
        return fIO;
    }

    public String getDateOfReceip() {
        return dateOfReceip;
    }

    public void setDateOfReceip(String dateOfReceip) {
        this.dateOfReceip = dateOfReceip;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setFIO(String fIO) {
        this.fIO = fIO;
    }
}
