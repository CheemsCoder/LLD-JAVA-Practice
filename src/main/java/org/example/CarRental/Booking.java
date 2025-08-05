package org.example.CarRental;

public class Booking {
    Car car;
    User user;
    String startDate;
    String endDate;
    BookingStatus bookingStatus;
    Integer totalPrice;

    public Booking(Car car, User user, String startDate, String endDate) throws Exception {
        this.car = car;
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bookingStatus = BookingStatus.PENDING;
        calculateTotalPrice();
    }

    private void calculateTotalPrice() throws Exception {
        // Assuming startDate and endDate are in the format "YYYY-MM-DD"
        String[] start = startDate.split("-");
        String[] end = endDate.split("-");

        int startDay = Integer.parseInt(start[2]);
        int endDay = Integer.parseInt(end[2]);

        int numberOfDays = endDay - startDay;

        if (numberOfDays < 0) {
            throw new Exception("End date must be after start date");
        }
        this.totalPrice = numberOfDays * car.rentalPricePerDay;
    }

    public void cancelBooking() {
        this.bookingStatus = BookingStatus.CANCELLED;
        car.ChangeStatus(CarStatus.FREE);
    }

    public void confirmBooking() {
        this.bookingStatus = BookingStatus.BOOKED;
        car.ChangeStatus(CarStatus.BOOKED);
    }

}
