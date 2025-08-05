package org.example.VendingMachine;

public class Demo {
    public static void main(String[] args) {
        VendingMachineManager  vendingMachineManager = VendingMachineManager.getInstance();

        Product p1 = vendingMachineManager.addProduct(1, 600, 1);
        Product p2 = vendingMachineManager.addProduct(2, 200, 1);
        Product p3 = vendingMachineManager.addProduct(3, 300, 1);

        vendingMachineManager.selectProduct(p1);

        Note n500 = new Note(NoteType.FIVE_HUNDRED, 500);
        Note n100 = new Note(NoteType.HUNDRED, 100);


        vendingMachineManager.insertNote(n500);
        vendingMachineManager.insertNote(n500);

        vendingMachineManager.dispenseProduce();
        vendingMachineManager.returnChange();

    }
}
