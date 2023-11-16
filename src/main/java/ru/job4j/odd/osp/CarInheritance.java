package ru.job4j.odd.osp;

import java.util.ArrayList;
import java.util.List;

public class CarInheritance {

    private static class Car {

        private String name;
        private int price;

        public Car(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public String sounds(String name) {
            return name + ":bep - bip";
        }

        @Override
        public String toString() {
            return "Car{" + "name='" + name + '\'' + ", price=" + price + '}';
        }
    }

    private static class NoSoundsCar extends Car {

        public NoSoundsCar(String name, int price) {
            super(name, price);
        }

        @Override
        public String sounds(String name) {
            return name + ": бесшумный";
        }
    }

    public static void main(String[] args) {
        List<Car> carList = List.of(new Car("Шкода", 686868), new Car("Фольсфагин", 473874), new NoSoundsCar("Электомобиль", 47483743));
        for (Car car : carList) {
            System.out.println(car.sounds(car.name));
        }
    }
}
