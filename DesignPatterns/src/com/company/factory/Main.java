package com.company.factory;

import java.util.Scanner;

public class Main {
    public static void gunsBlazing(Ship ship) {
        ship.display();
        ship.shoot();
    }

    public static void main(String[] args) {
        ShipFactory factory = new ShipFactory();

        Scanner input = new Scanner(System.in);
        String shipType = "";
        String shipName = "";

        System.out.println("What kind of ship do you want to create? (U / R)");
        if (input.hasNextLine()) {
            shipType = input.nextLine();
        }

        System.out.println("What do you want to name your ship?");
        if (input.hasNextLine()) {
            shipName = input.nextLine();
        }

        Ship ship = factory.createShip(shipType, shipName);

        gunsBlazing(ship);
    }

    /**
     * As we can see, our ship is created dynamically,
     * without need for the main class to know what kind of ship it's dealing with.
     * All the decision-making is moved over to the factory class.
     */
}
