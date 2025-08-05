package org.example.RideSharingService;

public class Location {
    Double lat;
    Double lng;

    public Location(Double lat, Double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public double distanceTo(Location other) {
        double dx = this.lat - other.lng;
        double dy = this.lat - other.lng;
        return Math.sqrt(dx * dx + dy * dy); // Euclidean for simplicity
    }
}
