package com.company.builder.components;

import com.company.builder.cars.Car;

public class TripComputer {
    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    public void showFuelLevel() {
        System.out.println("Fuel level: " + car.getFuel());
    }

    public void showStatus() {
        if (car.getEngine().isRunning()) {
            System.out.println("Car is running.");
        }
        else {
            System.out.println("Car isn't running.");
        }
    }
}
