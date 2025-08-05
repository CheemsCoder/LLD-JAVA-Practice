package org.example.PrakingLot;

public class ParkingSpot {
    Integer id;
    VehicleType vehicleType;
    ParkingFloor  parkingFloor;
    Boolean isFree;

    public ParkingSpot(Integer id, VehicleType vehicleType, ParkingFloor parkingFloor) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.parkingFloor = parkingFloor;
        this.isFree = true;
    }

    public Boolean park() {
        if(!isFree) {
            System.out.println("ParkingSpot not free");
            return false;
        }
        isFree = false;
        return true;
    }

    public Boolean unpark() {
        if(isFree) {
            System.out.println("ParkingSpot Already free");
        }
        isFree = true;
        return true;
    }


}
