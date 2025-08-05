package org.example.TrafiicSignalSytem;

public interface SignalState {
    void handle(TrafficLight light, TrafficSignalController controller, Direction direction);
    String getName();
}
