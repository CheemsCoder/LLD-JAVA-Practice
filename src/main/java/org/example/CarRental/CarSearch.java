package org.example.CarRental;


import java.util.ArrayList;
import java.util.List;
public class CarSearch {
    List<Car> carList;

    public CarSearch() {
        this.carList = new ArrayList<>();
    }

    public void addCar(Car car) {
        this.carList.add(car);
    }

    public List<Car> searchByModel(String model) {
        List<Car> result = new ArrayList<>();
        for (Car car : carList) {
            if (car.model.equalsIgnoreCase(model) && car.carStatus == CarStatus.FREE) {
                result.add(car);
            }
        }
        return result;
    }

    public List<Car> searchCarByPriceRange(Integer low, Integer high) {
        List<Car> result = new ArrayList<>();
        for (Car car : carList) {
            if (car.rentalPricePerDay >= low && car.rentalPricePerDay <= high && car.carStatus == CarStatus.FREE) {
                result.add(car);
            }
        }
        return result;
    }
}
