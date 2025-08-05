package org.example.PrakingLot;

public interface ParkingStrategy {
    public ParkingSpot findFreeSpot(ParkingFloor parkingFloor, VehicleType vehicleType);
}
