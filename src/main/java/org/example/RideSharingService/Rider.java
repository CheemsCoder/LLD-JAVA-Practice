package org.example.RideSharingService;

public class Rider {
    Integer id;
    String name;
    Location currentLocation;

    public Rider(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }
}
