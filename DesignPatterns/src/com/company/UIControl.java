package com.company;

/**
 * Here we implement the common behavior between our elements
 */
public abstract class UIControl {

    public void enable() {
        System.out.println("Enable");
    }

    public void disable() {
        System.out.println("Disable");
    }

    /*
    Now, for this example, we know that our elements that extend our 'UIControl' will all have to be drawn, but the 'draw' implementation is specific to each element.
    So we can declare this method abstract, because we won't implement it in our base class, and thus delegate the implementation to extending classes.
     */
    public abstract void draw();
}
