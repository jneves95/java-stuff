package com.company.state.abuse;

public class StoppedState implements State{
    private Stopwatch stopwatch;

    public StoppedState(Stopwatch stopwatch) {
        this.stopwatch = stopwatch;
    }

    @Override
    public void click() {
        stopwatch.setState(new RunningState(stopwatch));
        System.out.println("Running");
    }
}
