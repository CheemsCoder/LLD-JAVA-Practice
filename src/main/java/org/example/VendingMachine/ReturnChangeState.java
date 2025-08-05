package org.example.VendingMachine;

public class ReturnChangeState implements VendingMachineState {
    VendingMachineManager vendingMachineManager;
    public ReturnChangeState(VendingMachineManager vendingMachineManager) {
        this.vendingMachineManager = vendingMachineManager;
    }
    @Override
    public void selectProduct(final Product product) {
        System.out.println("Please collect the change first.");
    }

    @Override
    public void insertNote(final Note note) {
        System.out.println("Please collect the change first.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please collect the change first.");
    }

    @Override
    public void returnChange() {
        Integer change = vendingMachineManager.totalPayment - vendingMachineManager.product.price;
        if (change > 0) {
            System.out.println("Change returned: $" + change);
        } else {
            System.out.println("No change to return.");
        }

        vendingMachineManager.totalPayment = 0;
        vendingMachineManager.setState(vendingMachineManager.idleState);
        vendingMachineManager.product = null;
    }
}
