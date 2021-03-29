package com.company.factory;

public class ShipFactory {
    Ship createShip(String type, String name) {
        switch (type) {
            case "R":
                return new RocketShip(name);
            case "U":
                return new UFOShip(name);
        }

        // error - invalid type of ship given
        return null;
    }
}
