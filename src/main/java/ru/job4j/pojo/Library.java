package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book bible = new Book("Bible", 1000);
        Book cleanCod = new Book("Clean Cod", 300);
        Book javaTask = new Book("Java Task", 500);
        Book harryPotter = new Book("Harry Potter", 400);
        Book[] book = new Book[4];
        book[0] = bible;
        book[1] = cleanCod;
        book[2] = javaTask;
        book[3] = harryPotter;
        System.out.println("Выведение всего цикла");
        for (int index = 0; index < book.length; index++) {
            Book br = book[index];
            System.out.println(br.getName() + " - " + br.getCount());
        }
        System.out.println();
        System.out.println("Замена мест в массиве");
        Book temp = book[0];
        book[0] = book[3];
        book[3] = temp;
        for (int index = 0; index < book.length; index++) {
            Book br = book[index];
            System.out.println(br.getName() + " - " + br.getCount());
        }
        System.out.println();
        System.out.println("Цикл на утверждение равенста строки массива");
        for (int index = 0; index < book.length; index++) {
            Book br = book[index];
            if (book[index].equals(cleanCod)) {
                Book bri = book[index];
                System.out.println(bri.getName() + " - " + bri.getCount());
            }
        }
    }
}
