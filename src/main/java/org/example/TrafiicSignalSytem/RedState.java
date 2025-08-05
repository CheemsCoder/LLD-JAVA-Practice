package org.example.TrafiicSignalSytem;

public class RedState implements SignalState {
    @Override
    public void handle(final TrafficLight light, final TrafficSignalController controller,
            final Direction direction) {
        System.out.println("Direction: " + direction + " Light: " + "RED");
        int duration = controller.getSignalDuration(direction, this);
        Direction nextDirection = controller.getNextDuration(direction);

        controller.scheduleStateChange(
                controller.getTrafficLight(nextDirection),
                nextDirection,
                new GreenState(),
                duration
        );

    }

    @Override
    public String getName() {
        return "RED";
    }
}
