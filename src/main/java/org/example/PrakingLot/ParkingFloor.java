package org.example.PrakingLot;

import java.util.HashMap;
import java.util.*;
import java.util.Map;

public class ParkingFloor {
    Integer id;
    Map<Integer, ParkingSpot> parkingSpots;
    Map<VehicleType, Queue<ParkingSpot>> freeParkingSpots;
    ParkingStrategy parkingStrategy;

    public ParkingFloor(Integer id, ParkingStrategy parkingStrategy) {
        this.id = id;
        freeParkingSpots = new HashMap<>();
        for (VehicleType vehicleType : VehicleType.values()) {
            freeParkingSpots.put(vehicleType, new PriorityQueue<>((p, q) -> p.id.compareTo(q.id)));
        }
        this.parkingSpots = new HashMap<>();
        this.parkingStrategy = parkingStrategy;
    }

    public void addParkingSpot(ParkingSpot spot) {
        parkingSpots.putIfAbsent(spot.id, spot);
        freeParkingSpots.get(spot.vehicleType).add(spot);
    }

    public void removeParkingSpot(ParkingSpot spot) {
        parkingSpots.remove(spot.id);
        freeParkingSpots.get(spot.vehicleType).remove(spot);
    }

    public ParkingSpot getFreeSpot(VehicleType vehicleType) {
        return parkingStrategy.findFreeSpot(this, vehicleType);
    }

    public void park(ParkingSpot spot, Vehicle vehicle) {
        spot.park();
    }

    public void unpark(ParkingSpot spot) {
        spot.unpark();
    }

    public void displayStatus() {
        System.out.println("Floor -" + id);
        for(Map.Entry<Integer, ParkingSpot> entry : parkingSpots.entrySet()) {
            System.out.println("Parking Spot: " + entry.getKey());
            System.out.println("Status: " + entry.getValue().isFree);
        }
    }
}
