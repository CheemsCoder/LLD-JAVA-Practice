package org.example.ResturantManagement;

import java.util.List;
import java.util.UUID;

public class Order {
    String orderId;
    Table table;
    List<OrderItem> orderItemList;
    OrderStatus orderStatus;

    public Order(Table table, List<OrderItem> orderItemList) {
        this.orderId = UUID.randomUUID().toString();
        this.table = table;
        this.orderStatus = OrderStatus.PENDING;
        this.orderItemList = orderItemList;
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItemList.add(orderItem);
    }

    public void changeOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double calculateTotal() {
        Double total = 0.0;
        for (OrderItem orderItem : orderItemList) {
            MenuItem item = orderItem.item;
            total += item.price * orderItem.quantity;
        }
        return total;
    }

    public void markPreparing() {
        this.orderStatus = OrderStatus.PREPARING;
    }

    public void markReady() {
        this.orderStatus = OrderStatus.READY;
    }

    public void markServed() {
        this.orderStatus = OrderStatus.SERVED;
    }

    public void markPaid() {
        this.orderStatus = OrderStatus.PAID;
    }
}
