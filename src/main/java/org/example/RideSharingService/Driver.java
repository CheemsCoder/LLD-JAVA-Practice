package org.example.RideSharingService;

public class Driver {
    Integer id;
    String name;
    Location currentLocation;
    DriverStatus status;

    public Driver(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.status = DriverStatus.OFFLINE;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setStatus(DriverStatus status) {
        this.status = status;
    }
}
