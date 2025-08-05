package org.example.VendingMachine;

public class ReadyState implements VendingMachineState {
    VendingMachineManager vendingMachineManager;
    public ReadyState(VendingMachineManager vendingMachineManager) {
        this.vendingMachineManager = vendingMachineManager;
    }
    @Override
    public void selectProduct(final Product product) {
        System.out.println("Product Already Selected: " + vendingMachineManager.product.id);
    }

    @Override
    public void insertNote(final Note note) {
        vendingMachineManager.addNote(note);
        System.out.println("Note Inserted: " + note);
        checkPaymentStatus();
    }

    private void checkPaymentStatus() {
        if(vendingMachineManager.totalPayment >= vendingMachineManager.product.price) {
            vendingMachineManager.setState(vendingMachineManager.dispenseState);
        }
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please make payment first.");
    }

    @Override
    public void returnChange() {
        System.out.println("Please make payment first.");
    }
}
