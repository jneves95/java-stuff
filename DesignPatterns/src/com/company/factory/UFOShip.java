package com.company.factory;

public class UFOShip extends Ship {

    UFOShip(String name) {
        super(name, 50);
    }

    @Override
    void display() {
        System.out.println(getName() + " is a UFO ship!");
    }

    @Override
    void shoot() {
        System.out.println(getName() + " fires its lasers for " + getDamage() + " damage!");
    }
}
