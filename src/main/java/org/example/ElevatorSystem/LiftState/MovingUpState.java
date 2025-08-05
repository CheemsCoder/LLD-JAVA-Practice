package org.example.ElevatorSystem.LiftState;

import org.example.ElevatorSystem.Lift;

public class MovingUpState  extends LiftState {

    public MovingUpState(final Lift lift) {
        super(lift);
    }

    @Override
    public Integer getTimeToReach(final int floor, final char direction) {
        Integer currentFloor = lift.getCurrentFloor();
        Boolean hasStopInOppositeDirection = lift.hasStopInOppositeDirection();
        Integer maxFloor = lift.getMaxUpFloor();
        if(floor > maxFloor && hasStopInOppositeDirection) {
            return -1;
        }
        if(direction == 'D') {
            if( currentFloor > floor ) {
                return -1;
            }
            Integer time = floor - currentFloor;
            return time;
        }
        if (floor >= maxFloor) {
            int timeTaken = floor - currentFloor;
            return timeTaken;
        }

        Integer timeTaken = maxFloor - currentFloor + maxFloor - floor;
        return timeTaken;
    }

    @Override
    public char getDirection() {
        return 'U';
    }

    public void updateFloor() {
        int maxUpFloor = lift.getMaxUpFloor();
        if(lift.getCurrentFloor()<maxUpFloor) {
            lift.setCurrentFloor(lift.getCurrentFloor() + 1);
        }
    }

    public void updateDirection(){
        if(lift.getCurrentFloor()>=lift.getMaxUpFloor())
            lift.setState('D');
    }
}
