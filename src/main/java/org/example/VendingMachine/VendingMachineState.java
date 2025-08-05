package org.example.VendingMachine;

public interface VendingMachineState {
    void selectProduct(Product product);
    void insertNote(Note note);
    void dispenseProduct();
    void returnChange();
}
