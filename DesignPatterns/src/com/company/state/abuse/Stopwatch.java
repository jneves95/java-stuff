package com.company.state.abuse;

/**
 * Here we demonstrate how we can abuse the state pattern, we complicate a solution instead of simplifying it.
 *
 * In the following line comments we can see how we could have easily worked our Stopwatch class with a simple boolean and an if-else statement, and while the state pattern can be implemented
 * in this case, it certainly adds much more complexity than needed - an interface, two implementing classes, multiple references moving around from object to object, all plain unnecessary.
 */
public class Stopwatch {
//    private boolean isRunning;
    private State state = new StoppedState(this);

    public void click() {
        state.click();
//        System.out.println(isRunning ? "Stopped" : "Running");
//        isRunning = !isRunning;
    }

    public static void main(String[] args) {
        var stopwatch = new Stopwatch();
        stopwatch.click();
        stopwatch.click();
        stopwatch.click();
    }

    public void setState(State state) {
        this.state = state;
    }
}
