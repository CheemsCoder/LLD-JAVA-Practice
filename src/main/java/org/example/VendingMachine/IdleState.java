package org.example.VendingMachine;

public class IdleState implements VendingMachineState {
    VendingMachineManager vendingMachineManager;

    public IdleState(VendingMachineManager vendingMachineManager) {
        this.vendingMachineManager = vendingMachineManager;
    }
    @Override
    public void selectProduct(final Product product) {
        if(vendingMachineManager.inventory.isAvailable(product)) {
            System.out.println("Product selected: " + product.id);
            vendingMachineManager.product = product;
            vendingMachineManager.setState(vendingMachineManager.readyState);
        } else {
            System.out.println("Product Not Available: " + product.id);
        }
    }

    @Override
    public void insertNote(final Note note) {
        System.out.println("Please select a product first.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please select a product first.");
    }

    @Override
    public void returnChange() {
        System.out.println("Please select a product first.");
    }
}
