package com.company.builder.builders;

import com.company.builder.cars.CarType;
import com.company.builder.components.Engine;
import com.company.builder.components.GPSNavigator;
import com.company.builder.components.Transmission;
import com.company.builder.components.TripComputer;

public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}
