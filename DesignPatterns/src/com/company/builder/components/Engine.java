package com.company.builder.components;

public class Engine {
    private final double volume;
    private double mileage;
    private boolean running;

    public Engine(double volume, double mileage) {
        this.volume = volume;
        this.mileage = mileage;
    }

    public boolean isRunning() {
        return running;
    }

    public void on() {
        running = true;
    }

    public void off() {
        running = false;
    }

    public void go(double mileage) {
        if (running) {
            this.mileage += mileage;
        }
        else {
            System.err.println("Cannot go(), engine isn't running!");
        }
    }


    public double getVolume() {
        return volume;
    }

    public double getMileage() {
        return mileage;
    }

    public String toString() {
        return "Volume - " + volume + ", mileage - " + mileage;
    }
}
