package org.example.PrakingLot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ParkingSystem system = ParkingSystem.getInstance();

        ParkingStrategy parkingStrategy = new NearestFirstParkingStrategy();
        // Create parking floors with spots
        ParkingFloor floor0 = new ParkingFloor(0, parkingStrategy);
        floor0.addParkingSpot(new ParkingSpot(1, VehicleType.FOUR_WHEELER, floor0));
        floor0.addParkingSpot(new ParkingSpot(2, VehicleType.TWO_WHEELER, floor0));



        ParkingFloor floor1 = new ParkingFloor(1, parkingStrategy);
        floor1.addParkingSpot(new ParkingSpot(3, VehicleType.FOUR_WHEELER, floor1));
        floor1.addParkingSpot(new ParkingSpot(4, VehicleType.TWO_WHEELER, floor1));

        system.addParkingFloor(floor0);
        system.addParkingFloor(floor1);

        // Create vehicles
        Vehicle car1 = new Vehicle("KA-01-HH-1234", VehicleType.FOUR_WHEELER);
        Vehicle bike1 = new Vehicle("KA-01-HH-5678", VehicleType.TWO_WHEELER);

        // Park vehicles
        system.parkVehicle(car1);
        system.parkVehicle(bike1);

        // Display parking status
        System.out.println("\n--- Parking Status After Parking ---");
        system.displayStatus();

        // Unpark one vehicle
        system.unparkVehicle(car1);

        // Display parking status again
        System.out.println("\n--- Parking Status After Unparking Car ---");
        system.displayStatus();
    }
}
