package ru.job4j.tracker;

public class StubTransport implements Transport {

    final double priceGasoline = 41.5;

    @Override
    public void drive() {
        System.out.println("Transport went");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Passengers in transport - " + count);
    }

    @Override
    public double fillUp(int liters) {
        return liters * priceGasoline;
    }
}
