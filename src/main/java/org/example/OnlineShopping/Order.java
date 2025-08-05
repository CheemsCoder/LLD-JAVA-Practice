package org.example.OnlineShopping;

import java.util.Map;


public class Order {
    Integer orderId;
    User user;
    Map<Product, Integer> productQuantity;
    Double totalPrice;
    OrderStatus status;
    public Order(Integer orderId, User user, Map<Product, Integer> productQuantity) {
        this.orderId = orderId;
        this.user = user;
        this.productQuantity = productQuantity;
        this.status = OrderStatus.PENDING;
        this.totalPrice = CalculateTotalPrice();
    }

    private Double CalculateTotalPrice() {
        double total = 0.0;
        for(Map.Entry<Product, Integer> entry : productQuantity.entrySet()) {
            Integer quantity = entry.getValue();
            Product product = entry.getKey();
            total += quantity * product.price;
        }
        return total;
    }
}
