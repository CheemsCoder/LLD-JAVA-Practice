package org.example.RideSharingService;

import java.util.*;

public class RideSharingManager {
    private static RideSharingManager rideSharingManager;
    Map<Integer, Driver> drivers;
    Map<Integer, Rider> riders;
    Map<String, Trip> trips;

    private RideSharingManager() {
        this.drivers = new HashMap<>();
        this.riders = new HashMap<>();
        this.trips = new HashMap<>();
    }
    public static RideSharingManager getInstance() {
        if (rideSharingManager == null) {
            rideSharingManager = new RideSharingManager();
        }
        return rideSharingManager;
    }

    public void addDriver(Driver driver) {
        drivers.putIfAbsent(driver.id, driver);
    }

    public void addRider(Rider rider) {
        riders.putIfAbsent(rider.id, rider);
    }

    public Trip requestTrip(Rider rider, Location source, Location destination) {
        Trip trip = new Trip(rider, source, destination);
        notifyNearbyDrivers(trip);
        trips.putIfAbsent(trip.id, trip);
        return trip;
    }

    public void acceptTrip(Driver driver, Trip trip) {
        if(trip.tripStatus == TripStatus.REQUESTED) {
            Rider rider = trip.rider;
            trip.assignDriver(driver);
            trip.tripStatus = TripStatus.ONGOING;
            driver.setStatus(DriverStatus.ON_TRIP);
            notifyRider(trip);
            System.out.printf("Trip started: %s (Driver: %s -> Rider: %s)%n",
                    trip.id, driver.name, rider.name);
        }
    }

    public void completeTrip(Trip trip) {
        if(trip.tripStatus == TripStatus.ONGOING) {
            trip.driver.status = DriverStatus.AVAILABLE;
            notifyRider(trip);
            notifyDriver(trip);
            System.out.printf("Trip %s completed%n", trip.id);
            trip.completeTrip();
        }
    }

    public void cancelTrip(Trip trip) {
        if(trip.tripStatus == TripStatus.ONGOING || trip.tripStatus == TripStatus.REQUESTED) {
            if(trip.driver != null) {
                trip.driver.status = DriverStatus.AVAILABLE;
            }
            notifyDriver(trip);
            notifyRider(trip);
            trip.cancelTrip();
        }
    }

    private void notifyRider(Trip trip) {
        // Notify the passenger about ride status updates
        Rider rider = trip.rider;
        String message;
        switch (trip.tripStatus) {
            case ONGOING:
                message = "Your ride has been accepted by driver: " + trip.driver.name;
                break;
            case COMPLETED:
                message = "Your ride has been completed. Fare";
                break;
            case CANCELLED:
                message = "Your ride has been cancelled";
                break;
            default:
                message = "";
                break;
        }
        // Send notification to the passenger
        System.out.println("Notifying rider: " + rider.name + " - " + message);
    }

    private void notifyDriver(Trip trip) {
        Driver driver = trip.driver;
        String message = "";
        switch (trip.tripStatus) {
            case COMPLETED:
                message = "Your ride has been completed";
            case CANCELLED:
                message = "Your ride has been cancelled";
        }
        // Send notification to the driver
        System.out.println("Notifying driver: " + driver.name + " - " + message);
    }

    private void notifyNearbyDrivers(Trip trip) {
        boolean foundNearbyAvailableDriver = false;
        for(Driver driver : drivers.values()) {
            if(driver.status == DriverStatus.AVAILABLE) {
                double distance = trip.startLocation.distanceTo(driver.currentLocation);
                System.out.println("Driver: " + driver.name + " - " + distance);
                if(distance <= 300.0) {
                    foundNearbyAvailableDriver = true;
                    System.out.println("Notifying driver: " + driver.name + " about ride request: " + trip.id);
                }
            }
        }
        if(!foundNearbyAvailableDriver) {
            throw new IllegalStateException("No available drivers");
        }
    }
}
