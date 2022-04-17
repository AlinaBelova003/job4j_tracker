package ru.job4j.poly;

public class Bus implements Transport, Vehicle {
    @Override
    public void go() {
        System.out.println("Для автобуса характерно ехать медленно");
    }

    @Override
    public void passengers(int countPassengers) {
        System.out.println("Сейчас в автобусе" + countPassengers);

    }

    @Override
    public double refuel(double countFuel) {
        System.out.println("Этот автобус сжирает " + countFuel + " топлива. ");
        return countFuel;
    }

    @Override
    public void move() {
        System.out.println("Автобус едит по асфальту");
    }
}
