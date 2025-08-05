package org.example.OnlineShopping;


import java.util.*;
public class Cart {
    User user;
    Map<Product, Integer> products;

    public Cart(User user) {
        this.user = user;
        this.products = new HashMap<>();
    }

    public void addProduct(Product product, int amount) {
        Integer quantity = products.getOrDefault(product, 0);
        quantity += amount;
        products.put(product, quantity);
    }

    public Double totalPrice() {
        Double total = 0.0;
        for(Map.Entry<Product, Integer> entry : products.entrySet()) {
            Integer quantity = entry.getValue();
            Product product = entry.getKey();
            total += quantity * product.price;
        }
        return total;
    }
}
