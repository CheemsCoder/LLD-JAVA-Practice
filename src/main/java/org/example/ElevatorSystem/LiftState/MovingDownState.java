package org.example.ElevatorSystem.LiftState;

import org.example.ElevatorSystem.Lift;

public class MovingDownState extends LiftState {
    public MovingDownState(final Lift lift) {
        super(lift);
    }

    @Override
    public Integer getTimeToReach(final int floor, final char direction) {
        Integer currentFloor = lift.getCurrentFloor();
        Integer minDownFloor = lift.getMinDownFloor();
        Boolean hasStopInOppositeDirection = lift.hasStopInOppositeDirection();
        if(floor < minDownFloor && hasStopInOppositeDirection) {
            return -1;
        }
        if(direction == 'D') {
            if(floor > currentFloor) { return -1;}
            return currentFloor-floor;
        }
        if(floor <= minDownFloor) { return currentFloor- floor;}
        return currentFloor - minDownFloor + floor - minDownFloor;
    }

    @Override
    public char getDirection() {
        return 'D';
    }

    public void updateFloor() {
        Integer currentFloor = lift.getCurrentFloor();
        Integer minDownFloor = lift.getMinDownFloor();
        if(currentFloor > minDownFloor) {
            lift.setCurrentFloor(currentFloor - 1);
        }
    }
    public void updateDirection() {
        Integer currentFloor = lift.getCurrentFloor();
        Integer minDownFloor = lift.getMinDownFloor();
        if(currentFloor <= minDownFloor) {
            lift.setState('U');
        }
    }
}
