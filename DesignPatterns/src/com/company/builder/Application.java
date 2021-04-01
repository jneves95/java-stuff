package com.company.builder;

import com.company.builder.builders.CarBuilder;
import com.company.builder.builders.ManualBuilder;
import com.company.builder.cars.Car;
import com.company.builder.cars.Manual;
import com.company.builder.director.Director;

public class Application {
    public static void main(String[] args) {
        Director director = new Director();
        CarBuilder carBuilder = new CarBuilder();

        director.buildSportsCar(carBuilder);

        Car car = carBuilder.getResult();
        car.getEngine().go(345.8);
        car.getEngine().on();
        car.getEngine().go(345.8);
        car.getEngine().off();

        System.out.println("Mileage: " + car.getEngine().getMileage());

        ManualBuilder manualBuilder = new ManualBuilder();

        director.buildSportsCar(manualBuilder);

        Manual carManual = manualBuilder.getResult();
        System.out.println("MANUAL:\n" + carManual.print());
    }
}
