package org.example.RideSharingService;

import java.util.UUID;

public class Trip {
    Driver driver;
    Rider rider;
    Location startLocation;
    Location endLocation;
    TripStatus  tripStatus;
    Payment payment;
    String id;

    public Trip(Rider rider, Location startLocation, Location endLocation) {
        this.rider = rider;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.driver = null;
        this.tripStatus = TripStatus.REQUESTED;
        this.id = UUID.randomUUID().toString();
        this.payment = new UpiPayment();
    }

    public void assignDriver(Driver driver) {
        if(this.driver != null) {
            System.out.println("Driver already assigned to trip");
        }
        this.driver = driver;
        this.tripStatus = TripStatus.ONGOING;
    }

    public void completeTrip() {
        this.tripStatus = TripStatus.COMPLETED;
        payment.process(calculatePayment());
    }

    private Integer calculatePayment() {
        return 10;
    }

    public void cancelTrip() {
        this.tripStatus = TripStatus.CANCELLED;
        this.rider = null;
        this.payment = null;
    }
}
