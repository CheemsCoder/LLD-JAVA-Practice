package org.example.TrafiicSignalSytem;

public class GreenState implements SignalState {

    @Override
    public void handle(final TrafficLight light, final TrafficSignalController controller,
            final Direction direction) {
        System.out.println("Direction: " + direction + "Light: Green");
        Integer duration = controller.getSignalDuration(direction, this);
        controller.scheduleStateChange(light, direction, new YellowState(), duration);
    }

    @Override
    public String getName() {
        return "GREEN";
    }
}
