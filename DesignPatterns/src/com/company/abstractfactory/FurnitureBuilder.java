package com.company.abstractfactory;

public class FurnitureBuilder {
    FurnitureFactory createFactory(String type) {
        switch (type) {
            case "M":
                return new ModernFurnitureFactory();
            case "V":
                return new VictorianFurnitureFactory();
        }

        return null;
    }
}
