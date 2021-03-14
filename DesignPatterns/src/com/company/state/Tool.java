package com.company.state;

/**
 * To demonstrate the difference between an interface and an abstract class, we kept the code for our Tool as an abstract class instead of an interface.
 * Why is interface more adequate in this case?
 *   Well, Interface and Abstract class are both abstract concepts, which means they cannot be instantiated, but in an abstract class we can have some
 *   common code implementation for our child classes, while in an interface everything should be implemented in our child classes.
 *   (We can see an example of where an abstract class is needed in our UIControl class from other patterns)
 *
 *   public abstract class Tool {
 *     public abstract void mouseDown();
 *     public abstract void mouseUp();
 *   }
 */

public interface Tool {
    void mouseDown();
    void mouseUp();
}

