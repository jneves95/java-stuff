package com.company.factory;

public class RocketShip extends Ship {

    RocketShip(String name) {
        super(name, 15);
    }

    @Override
    void display() {
        System.out.println(getName() + " is a rocket ship!");
    }

    @Override
    void shoot() {
        System.out.println(getName() + " shoots a rocket for an explosive " + getDamage() + " damage!");
    }
}
