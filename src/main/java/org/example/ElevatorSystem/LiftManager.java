package org.example.ElevatorSystem;

import java.util.*;

public class LiftManager {
    List<Lift>lifts;

    public LiftManager(Integer liftCount) {
        lifts = new ArrayList<>();
        for(int i=0;i<liftCount;i++) {
            Lift lift = new Lift(i, 10);
            lifts.add(lift);
        }
    }

    public Integer requestLift(Integer source, Integer destination) {
        if(source==destination) { return -1; }
        Integer liftId = -1;
        Integer timeToReachStart = 1000*1000;
        char direction = source<destination?'U':'D';
        for(Lift lift : lifts) {
            Integer reachStart = lift.getTimeToReachFloor(source, direction);
            Integer reachEnd = lift.getTimeToReachFloor(destination, direction);
            if(reachEnd < 0 || reachStart < 0 || reachStart > timeToReachStart) {
                continue;
            }
            if(reachStart<timeToReachStart){
                liftId=lift.id;
                timeToReachStart=reachStart;
            }
        }
        if(liftId>=0 && liftId< lifts.size())
            lifts.get(liftId).addRequest(new Request(source, destination));
        return liftId;
    }

    public String[] getLiftStates() {
        String liftStates[]=new String[lifts.size()];
        for(int i = 0; i< lifts.size() ; i++){
            liftStates[i]=""+ lifts.get(i).getCurrentFloor()
                    +'-'+ lifts.get(i).getMoveDirection();
        }
        return liftStates;
    }

    public void tick() {
        for(int i = 0; i< lifts.size(); i++)
            lifts.get(i).updateLiftState();
    }

}
