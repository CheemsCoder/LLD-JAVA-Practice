package org.example.TrafiicSignalSytem;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TrafficSignalController {
    private Map<Direction, TrafficLight> signals;
    private Map<Direction, Map<String, Integer>> signalDurations;
    private ScheduledExecutorService scheduler;
    public TrafficSignalController(Map<Direction, TrafficLight> signals, Map<Direction, Map<String, Integer>> signalDurations) {
        this.signals = signals;
        this.signalDurations = signalDurations;
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
    }

    public void scheduleStateChange(TrafficLight light, Direction direction, SignalState nextState, int delaySeconds) {
        Runnable command= new Runnable() {
            @Override
            public void run() {
                light.setState(nextState);
                light.handle(TrafficSignalController.this);
            }
        };
        scheduler.schedule(command, delaySeconds, TimeUnit.SECONDS);
    }

    public int getSignalDuration(Direction direction, SignalState state) {
        return signalDurations.get(direction).get(state.getName());
    }

    public Direction getNextDuration(Direction current) {
        Direction[] directions = Direction.values();
        int next = (current.ordinal() + 1) % directions.length;
        return directions[next];
    }

    public TrafficLight getTrafficLight(Direction direction) {
        return signals.get(direction);
    }

    public void start(Direction startDirection) {
        TrafficLight light = signals.get(startDirection);
        light.setState(new GreenState());
        light.handle(this);
    }
    public void manualOverride(Direction direction) {
        // Immediately set the specified direction to GREEN and start its cycle
        TrafficLight light = signals.get(direction);
        light.setState(new GreenState());
        light.handle(this);
    }
}
