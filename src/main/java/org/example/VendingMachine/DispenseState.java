package org.example.VendingMachine;

public class DispenseState implements VendingMachineState {
    VendingMachineManager vendingMachineManager;
    public DispenseState(VendingMachineManager vendingMachineManager) {
        this.vendingMachineManager = vendingMachineManager;
    }
    @Override
    public void selectProduct(final Product product) {
        System.out.println("Product already selected. Please collect the dispensed product.");
    }

    @Override
    public void insertNote(final Note note) {
        System.out.println("Payment already made. Please collect the dispensed product.");
    }

    @Override
    public void dispenseProduct() {
        Product product = vendingMachineManager.product;
        vendingMachineManager.inventory.updateQuantity(product, vendingMachineManager.inventory.getQuantity(product)-1);
        System.out.println("Product dispensed: " + product.id);
        vendingMachineManager.setState(vendingMachineManager.returnChangeState);
    }

    @Override
    public void returnChange() {

    }
}
