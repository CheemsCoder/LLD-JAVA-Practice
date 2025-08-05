package org.example.ResturantManagement;

import java.awt.Menu;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.ResturantManagement.Payment.Payment;

public class RestaurantManagementSystem {
    private static RestaurantManagementSystem instance;
    Map<String, MenuItem> menu;
    Map<String, Order> orders;
    List<Reservation> reservations;
    Map<Integer, Table> tables;
    Map<Integer, Payment> payments;

    private RestaurantManagementSystem() {
        menu = new HashMap<>();
        orders = new HashMap<>();
        reservations = new ArrayList<>();
        tables = new HashMap<>();
        payments = new HashMap<>();
    }

    public static RestaurantManagementSystem getInstance() {
        if(instance == null) {
            instance = new RestaurantManagementSystem();
        }
        return instance;
    }

    public MenuItem addMenuItem(String name, Double price) {
        MenuItem menuItem = new MenuItem(name, price);
        menu.put(name, menuItem);
        return menuItem;
    }

    public void removeMenuItem(String itemName) {
        menu.remove(itemName);
    }

    public List<MenuItem> getMenu() {
        return new ArrayList<>(menu.values());
    }

    public Table addTable(int tableId, int capacity) {
        Table table = new Table(tableId, capacity);
        tables.put(tableId, table);
        return table;
    }

    private void reserveTable(int tableId) {
        Table table = tables.get(tableId);
        if(table == null) {
            throw new IllegalArgumentException("Invalid table ID");
        }
        table.reserve();
    }

    public Reservation makeReservation(Table table, Customer customer, Timestamp reservationTime) {
        Reservation reservation = new Reservation(table, customer, reservationTime);
        reserveTable(table.tableNumber);
        reservations.add(reservation);
        return reservation;
    }

    public void cancelReservation(Reservation reservation) {
        reservations.remove(reservation);
        reservation.table.release();
    }

    public Order placeOrder(Table table, List<OrderItem> items) {
        if (table == null || table.isAvailable)
            throw new IllegalStateException("Table not reserved or invalid");
        Order order = new Order(table, items);
        orders.put(order.orderId, order);
        return order;
    }

    public void markOrderPreparing(String orderId) {
        Order order = orders.get(orderId);
        order.markPreparing();
    }

    public void markOrderReady(String orderId) {
        Order order = orders.get(orderId);
        order.markReady();
    }

    public void markOrderServed(String orderId) {
        Order order = orders.get(orderId);
        order.markServed();
    }

    public Bill getBill(String orderId) {
        Order order = orders.get(orderId);

        if (order.orderStatus == OrderStatus.PAID)
            throw new IllegalStateException("Order already paid");

        order.markPaid();
        return new Bill(order.orderId, order.calculateTotal());
    }

    public void makePayment(Bill bill, Payment payment) {
        Order order = orders.get(bill.getOrderId());

        if (payment.processPayment(bill.getTotalAmount())) {
            bill.markPaymentCompleted();
            order.markPaid();
        } else {
            bill.markPaymentFailed();
            throw new RuntimeException("Payment failed for the orderId: " + order.orderId);
        }
    }




}
