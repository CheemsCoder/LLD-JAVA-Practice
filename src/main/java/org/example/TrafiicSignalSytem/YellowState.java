package org.example.TrafiicSignalSytem;

public class YellowState implements SignalState {
    @Override
    public void handle(final TrafficLight light, final TrafficSignalController controller,
            final Direction direction) {
        System.out.println("Direction: " + direction + "Light: Yellow");
        Integer duration = controller.getSignalDuration(direction, this);
        controller.scheduleStateChange(light, direction, new RedState(), duration);
    }

    @Override
    public String getName() {
        return "GREEN";
    }
}
