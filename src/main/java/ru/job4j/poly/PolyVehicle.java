package ru.job4j.poly;

public class PolyVehicle {
    public static void main(String[] args) {
        Vehicle plain = new Plain();
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle[] vehicles = new Vehicle[] {plain, train, bus};
        for (Vehicle i : vehicles) {
            i.move();
        }
    }
}
