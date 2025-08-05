package org.example.PrakingLot;

import java.util.Map;
import java.util.Queue;

public class NearestFirstParkingStrategy implements ParkingStrategy {
    @Override
    public ParkingSpot findFreeSpot(final ParkingFloor parkingFloor, VehicleType vehicleType) {
       Map<VehicleType, Queue<ParkingSpot>> freeSpots = parkingFloor.freeParkingSpots;
       Queue<ParkingSpot> parkingSpots = freeSpots.get(vehicleType);
       if(parkingSpots == null || parkingSpots.isEmpty()) {
           System.out.println("No parking spots available for " + vehicleType + " in " + parkingFloor.id);
           return null;
       }
       return parkingSpots.poll();
    }
}
