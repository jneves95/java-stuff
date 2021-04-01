package com.company.builder.director;

import com.company.builder.builders.Builder;
import com.company.builder.cars.CarType;
import com.company.builder.components.Engine;
import com.company.builder.components.GPSNavigator;
import com.company.builder.components.Transmission;
import com.company.builder.components.TripComputer;

public class Director {
    public void buildCityCar(Builder builder) {
        builder.setCarType(CarType.CITY_CAR);
        builder.setSeats(4);
        builder.setEngine(new Engine(1.2, 0));
        builder.setTransmission(Transmission.AUTOMATIC);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void buildSportsCar(Builder builder) {
        builder.setCarType(CarType.SPORTS_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(3.0, 0));
        builder.setTransmission(Transmission.MANUAL);
        builder.setTripComputer(new TripComputer());
    }

    public void buildSUV(Builder builder) {
        builder.setCarType(CarType.SUV);
        builder.setSeats(5);
        builder.setEngine(new Engine(2.5, 0));
        builder.setTransmission(Transmission.SEMI_AUTOMATIC);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }
}
