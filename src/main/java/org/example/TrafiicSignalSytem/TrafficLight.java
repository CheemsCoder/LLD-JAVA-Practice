package org.example.TrafiicSignalSytem;

public class TrafficLight {
    Direction direction;
    SignalState state;
    public TrafficLight(Direction direction) {
        this.direction = direction;
        this.state = new RedState();
    }

    public void setState(SignalState state) {
        this.state = state;
    }

    public SignalState getState() {
        return state;
    }

    public Direction getDirection() {
        return direction;
    }

    public void handle(TrafficSignalController controller) {
        state.handle(this, controller, direction);
    }
}
