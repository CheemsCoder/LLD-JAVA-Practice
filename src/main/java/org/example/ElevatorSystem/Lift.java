package org.example.ElevatorSystem;

import java.util.*;

import org.example.ElevatorSystem.LiftState.IdleState;
import org.example.ElevatorSystem.LiftState.LiftState;
import org.example.ElevatorSystem.LiftState.MovingDownState;
import org.example.ElevatorSystem.LiftState.MovingUpState;


public class Lift {
    Integer id;
    List<Request> requests;
    Integer currentFloor;
    Integer capacity;
    LiftState movingUpState;
    LiftState movingDownState;
    LiftState idleState;
    LiftState currentState;

    public Lift(Integer id, Integer capacity) {
        this.id = id;
        this.currentFloor = 0;
        requests = new ArrayList<>();
        this.capacity = capacity;
        this.movingUpState = new MovingUpState(this);
        this.idleState = new IdleState(this);
        this.movingDownState = new MovingDownState(this);
        this.currentState = idleState;
    }

    public Boolean hasStopInOppositeDirection() {
        if(currentState.getDirection() == 'I') return false;
        for(Request request : requests) {
            if(request.getDirection() != currentState.getDirection()) return true;
        }
        return false;
    }

    public Integer getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(Integer currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void setState(char direction){
        if(direction=='U'){
            this.currentState=movingUpState;
            return;
        }
        if(direction=='D'){
            this.currentState=movingDownState;
            return;
        }
        this.currentState = idleState;
    }

    public Integer getMaxUpFloor() {
        Integer maxFloor = -1;
        for(Request request : requests) {
            if(request.source > maxFloor) maxFloor = request.source;
            if(request.destination > maxFloor) maxFloor = request.destination;
        }
        return maxFloor;
    }

    public Integer getMinDownFloor() {
        Integer minFloor = 1000*1000;
        for(Request request : requests) {
            if(request.source < minFloor) minFloor = request.source;
            if(request.destination < minFloor) minFloor = request.destination;
        }
        return minFloor;
    }

    public Integer getTimeToReachFloor(Integer floor, char direction) {
        return currentState.getTimeToReach(floor, direction);
    }

    public void addRequest(Request request) {
        requests.add(request);
        if(requests.size() == 1) {
            char direction = request.getDirection();
            if(request.source > currentFloor) {
                direction = 'U';
            }
            if(request.source < currentFloor) {
                direction = 'D';
            }
            setState(direction);
        }
    }

    public void updateRequests() {
        char direction = currentState.getDirection();
        if(direction == 'I'){
            return;
        }
        List<Request> newRequests = new ArrayList<>();
        for(Request request : requests) {
            if(direction == request.getDirection()){
                if(currentFloor>= request.destination && direction == 'U') {
                    continue;
                }
                if(currentFloor <= request.destination && direction == 'D') {
                    continue;
                }
            }
            newRequests.add(request);
        }
        requests = newRequests;
    }

    public void updateLiftState() {
        if(requests.size() == 0 || currentState.getDirection() == 'I') {
            return;
        }
        currentState.updateFloor();
        updateRequests();
        if(requests.size() == 0) { currentState = idleState; }
        else currentState.updateDirection();
    }

    public char getMoveDirection() {
        return currentState.getDirection();
    }

}
