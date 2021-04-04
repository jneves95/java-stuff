package com.company.examples;

public class User {
    public String name;
    public int age;

    public User() {}
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Hi, my name is " + name);
    }
}
