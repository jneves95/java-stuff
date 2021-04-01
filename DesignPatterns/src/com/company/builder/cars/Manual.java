package com.company.builder.cars;

import com.company.builder.components.Engine;
import com.company.builder.components.GPSNavigator;
import com.company.builder.components.Transmission;
import com.company.builder.components.TripComputer;

public class Manual {
    private final CarType carType;
    private final int seats;
    private final Engine engine;
    private final Transmission transmission;
    private final TripComputer tripComputer;
    private final GPSNavigator gpsNavigator;

    public Manual(CarType carType, int seats, Engine engine, Transmission transmission, TripComputer tripComputer, GPSNavigator gpsNavigator) {
        this.carType = carType;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
        this.tripComputer = tripComputer;
        this.gpsNavigator = gpsNavigator;
    }

    public String print() {
        String info = "";
        info += "Type of car: " + carType.toString().toLowerCase().replace('_', ' ') + "\n";
        info += "Number of seats: " + seats + "\n";
        info += "Engine: " + engine.toString() + "\n";
        info += "Transmission: " + transmission.toString().toLowerCase().replace('_', ' ') + "\n";
        info += "Trip computer: " + (tripComputer != null ? "Functional" : "N/A") + "\n";
        info += "GPS Navigator: " + (gpsNavigator != null ? "Functional" : "N/A") + "\n";

        return info;
    }
}
