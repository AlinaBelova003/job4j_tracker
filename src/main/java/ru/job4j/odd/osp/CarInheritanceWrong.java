package ru.job4j.odd.osp;

import java.util.List;

/**
 * Пример нарушающий принцип OSP
 * На вход приходит изменение поведения объекта, вместо того чтобы создать отдельную сущность со своей логикой через наследование,
 * мы порождаем отдельный метод, выполняющий одну функцию, но отличающийся только логикой.
 */
public class CarInheritanceWrong {

    public static class Car {

        public Car() {

        }

        public static String sounds(Car car) {
            return car + "bip - bip";
        }

        public static String soundWithoutSound(Car car) {
            return car + " ";
        }
    }

    public static void main(String[] args) {
        List<Car> carList = List.of(new Car(), new Car(), new Car());
        carList.forEach(Car::sounds);
        carList.forEach(Car::soundWithoutSound);
    }
}
