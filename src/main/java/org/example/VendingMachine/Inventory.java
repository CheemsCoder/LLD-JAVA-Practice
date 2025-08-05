package org.example.VendingMachine;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Product, Integer> inventory;
    public Inventory() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        inventory.put(product, quantity);
    }

    public void removeProduct(Product product) {
        inventory.remove(product);
    }

    public void updateQuantity(Product product, int quantity) {
        inventory.put(product, quantity);
    }

    public Integer getQuantity(Product product) {
        return inventory.get(product);
    }

    public boolean isAvailable(Product product) {
        return inventory.containsKey(product) && inventory.get(product) > 0;
    }
}
