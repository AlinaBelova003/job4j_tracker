package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public void printInfo() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
    }

    public Error(boolean active, int status, String message) {
    this.active = active;
    this.status = status;
    this.message = message;
}

    public Error() {
    }

    public static void main(String[] args) {
        Error errorDef = new Error();
        errorDef.printInfo();
        System.out.println();
        Error error = new Error(true, 2, "method");
        error.printInfo();

    }

}
