package ru.job4j.enumeration;

public class CarService {
    public static void main(String[] args) {
        Status toyota = Status.FINISHED;
        Status volvo = Status.WAITING;
        System.out.println("Статус Toyota: " + toyota);
        System.out.println("Статус Volvo: " + volvo);
        Order order = new Order(1, "Mercedes-Benz GLS", Status.IN_WORK);
        Order order2 = new Order(2, "Mercedes-Benz 123", Status.ACCEPTED);
        Order order3 = new Order(3, "Mercedes-Benz 455", Status.WAITING);
        Order order4 = new Order(4, "Mercedes-Benz 124", Status.FINISHED);
        Order order5 = new Order(5, "Mercedes-Benz 870", Status.ACCEPTED);
        System.out.println("Заказ-наряд №" + order2.getNumber() + " на автомобиль " + order2.getCar()
                + ", статус ремонта: " + order2.getStatus().getInfo());
        System.out.println("Заказ-наряд №" + order4.getNumber() + " на автомобиль " + order4.getCar()
                + ", статус ремонта: " + order4.getStatus().getInfo() + order4.getStatus().getMessage());

        Status[] status = Status.values();
        for (Status s : status) {
            System.out.println("Название статуса: " + s.name() + ", Порядковый номер статуса: " + s.ordinal());
        }
}

}
