package com.company;

/*
Interfaces are contracts that specify the capabilities a class should provide.
By using interfaces, we loosen the coupling between classes, which helps maintain our codebase light and extendable.

Without using interfaces, every time we made a change in one class, this change would reverberate to every class that uses or depends on this class.
This means that all the depending classes would need to be adapted or at least recompiled to accommodate the new change.
 */
public interface TaxCalculator {
    float calculateTax();
}
