package org.example.ElevatorSystem.LiftState;

import org.example.ElevatorSystem.Lift;

public class IdleState extends LiftState {
    public IdleState(final Lift lift) {
        super(lift);
    }

    @Override
    public Integer getTimeToReach(final int floor, final char direction) {
        return Math.abs(lift.getCurrentFloor()-floor);
    }

    @Override
    public char getDirection() {
        return 'I';
    }
}
