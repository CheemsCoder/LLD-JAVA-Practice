package org.example.RideSharingService;

public class Main {
    public static void main(String[] args) {
        RideSharingManager rideSharingService = RideSharingManager.getInstance();


        Rider user1 = new Rider(1, "John Doe");
        rideSharingService.addRider(user1);
        Rider user2 = new Rider(2, "Jane Smith");
        rideSharingService.addRider(user2);

        Driver driver1 = new Driver(1, "Alice Johnson");
        driver1.setCurrentLocation(new Location(37.7749, -122.4194));
        driver1.setStatus(DriverStatus.AVAILABLE);
        rideSharingService.addDriver(driver1);

        Driver driver2 = new Driver(2, "Bob Williams");
        driver2.setCurrentLocation(new Location(37.7860, -122.4070));
        driver2.setStatus(DriverStatus.AVAILABLE);
        rideSharingService.addDriver(driver2);

        Trip trip1 = rideSharingService.requestTrip(user1, new Location(32.7887, -112.4098), new Location(37.7887, -122.4098));

        rideSharingService.acceptTrip(driver1, trip1);

        rideSharingService.completeTrip(trip1);

        Trip trip2 = rideSharingService.requestTrip(user2, new Location(27.7749, -102.6124),
                new Location(37.7749, -122.4194));
        rideSharingService.acceptTrip(driver2, trip2);
        rideSharingService.cancelTrip(trip2);
    }
}
