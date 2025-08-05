package org.example.CarRental;

public class Car {
    String model;
    Integer id;
    String numberPlate;
    Integer rentalPricePerDay;
    CarStatus carStatus;

    public Car(String model, Integer id, String numberPlate, Integer rentalPricePerDay) {
        this.model = model;
        this.id = id;
        this.numberPlate = numberPlate;
        this.rentalPricePerDay = rentalPricePerDay;
        this.carStatus = CarStatus.FREE;
    }

    public void ChangeStatus(CarStatus status) {
        this.carStatus = status;
    }
}
