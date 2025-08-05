package org.example.PrakingLot;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class ParkingSystem {
    private static ParkingSystem instance;
    Map<Integer, ParkingFloor> parkingFloors;
    Map<String, AbstractMap.SimpleEntry<ParkingFloor, ParkingSpot>> parkingSnapshot;
    private ParkingSystem() {
        parkingFloors = new HashMap<>();
        parkingSnapshot = new HashMap<>();
    }

    public static ParkingSystem getInstance() {
        if (instance == null) {
            instance = new ParkingSystem();
        }
        return instance;
    }

    public void addParkingFloor(ParkingFloor floor) {
        parkingFloors.putIfAbsent(floor.id, floor);
    }

    public void parkVehicle(Vehicle vehicle) {
        Integer parkingSpotId = Integer.MAX_VALUE;
        ParkingFloor floor2 = null;
        ParkingSpot spot2 = null;
        for(ParkingFloor floor : parkingFloors.values()) {
            ParkingSpot spot = floor.getFreeSpot(vehicle.type);
            if(spot != null && spot.id < parkingSpotId) {
                parkingSpotId = spot.id;
                floor2 = floor;
                spot2 = spot;
            }
        }
        if(floor2 != null) {
            floor2.park(spot2, vehicle);
            parkingSnapshot.putIfAbsent(vehicle.number, new AbstractMap.SimpleEntry<>(floor2, spot2));
        }
    }

    public void unparkVehicle(Vehicle vehicle) {
        ParkingFloor floor = parkingSnapshot.get(vehicle.number).getKey();
        ParkingSpot spot = parkingSnapshot.get(vehicle.number).getValue();
        floor.unpark(spot);
    }

    public void displayStatus() {
        for(int i=0;i<parkingFloors.size();i++) {
            parkingFloors.get(i).displayStatus();
        }
    }
}
