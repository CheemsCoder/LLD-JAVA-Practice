package org.example.ElevatorSystem.LiftState;

import org.example.ElevatorSystem.Lift;

public abstract class LiftState {
    Lift lift;
    LiftState(Lift lift) {
        this.lift = lift;
    }

    public void updateFloor() {}
    public void updateDirection() {}
    public abstract Integer getTimeToReach(int floor, char direction);
    public abstract char getDirection();

}
