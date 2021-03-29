package com.company.factory;

public abstract class Ship {
    private String name;
    private int damage;

    Ship(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    abstract void display();
    abstract void shoot();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
