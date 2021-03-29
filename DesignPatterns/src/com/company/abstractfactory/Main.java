package com.company.abstractfactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FurnitureBuilder builder = new FurnitureBuilder();

        String furnitureType = "";
        Scanner input = new Scanner(System.in);

        System.out.println("What kind of furniture do you want? (M)odern / (V)ictorian");

        if (input.hasNextLine()) {
            furnitureType = input.nextLine();
        }

        FurnitureFactory factory = builder.createFactory(furnitureType);

        if (factory != null) {
            Chair chair = factory.createChair();
            Table table = factory.createTable();
            Sofa sofa = factory.createSofa();

            chair.sitOn();
            table.eatOn();
            sofa.loungeOn();
        }
    }
}

/**
 * We use the abstract factory method when we have families of distinct but related objects.
 *
 * We want to guarantee that these objects are all from the same family when we order them, but instead of having decision-making statements in a single factory,
 * we can instead also abstract and encapsulate the factory itself.
 *
 * By then having concrete factories for each of our concrete families,
 * both the objects and their creators are abstracted from our driver code,
 * and can be dynamically added or changed on run-time.
 *
 * It's pretty much extending on the same premise that led us to have the factory pattern, to the factory itself.
 */
