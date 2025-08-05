package org.example.ResturantManagement;

public class OrderItem {
    MenuItem item;
    Integer quantity;

    public OrderItem(MenuItem item, Integer quantity) {
        this.item = item;
        this.quantity = quantity;
    }
}
