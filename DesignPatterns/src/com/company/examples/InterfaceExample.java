package com.company.examples;

public class InterfaceExample {

    public static void main(String[] args) {
        TaxCalculator calculator = getCalculator(); // Here we are working with interfaces only, our main program doesn't know anything about the implementation.
        calculator.calculateTax();
    }

    public static TaxCalculator getCalculator() {
        return new TaxCalculator2019();
        // Although here we are still directly referencing a class, which implies dependency,
        // and this means that any change to this class would require our main program to be recompiled.
    }
}
