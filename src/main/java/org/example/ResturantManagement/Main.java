package org.example.ResturantManagement;

import java.sql.Timestamp;
import java.util.*;

import org.example.ResturantManagement.Payment.UPIPayment;

public class Main {
    public static void main(String[] args) {
        RestaurantManagementSystem restaurantManagementSystem = RestaurantManagementSystem.getInstance();

        // Add menu items
        MenuItem menuItem1 = restaurantManagementSystem.addMenuItem("Burger", 9.99);
        MenuItem menuItem2 = restaurantManagementSystem.addMenuItem("Pizza", 12.99);
        MenuItem menuItem3 = restaurantManagementSystem.addMenuItem("Salad", 7.99);


        Table table1 = restaurantManagementSystem.addTable(1, 5);
        Table table2 = restaurantManagementSystem.addTable(2, 4);

        Customer customer = new Customer(1, "John Doe");
        Reservation reservation = restaurantManagementSystem.makeReservation(table1,  customer, new Timestamp(System.currentTimeMillis()));

        // Place an order
        Order order = restaurantManagementSystem.placeOrder(table1, List.of(
                new OrderItem(menuItem1, 1),
                new OrderItem(menuItem3, 2)
        ));

        // Update order status
        restaurantManagementSystem.markOrderPreparing(order.orderId);
        restaurantManagementSystem.markOrderReady(order.orderId);
        restaurantManagementSystem.markOrderServed(order.orderId);

        // Process payment
        Bill bill = restaurantManagementSystem.getBill(order.orderId);
        restaurantManagementSystem.makePayment(bill, new UPIPayment());

        // Make a reservation


        // Get menu
        List<MenuItem> menu = restaurantManagementSystem.getMenu();
        System.out.println("Menu:");
        for (MenuItem item : menu) {
            System.out.println(item.name + " - $" + item.price);
        }
    }
}
