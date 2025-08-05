package org.example.VendingMachine;

public class VendingMachineManager {
    private static VendingMachineManager instance;
    Inventory inventory;
    VendingMachineState vendingMachineState;
    Product product;
    Integer totalPayment;
    IdleState idleState;
    ReadyState readyState;
    DispenseState dispenseState;
    ReturnChangeState  returnChangeState;

    private VendingMachineManager() {
        idleState = new IdleState(this);
        readyState = new ReadyState(this);
        dispenseState = new DispenseState(this);
        returnChangeState = new ReturnChangeState(this);
        inventory = new Inventory();
        vendingMachineState = idleState;
        product = null;
        totalPayment = 0;
    }

    public static VendingMachineManager getInstance() {
        if (instance == null) {
            instance = new VendingMachineManager();
        }
        return instance;
    }

    public Product addProduct(Integer id, Integer price, Integer quantity) {
        Product product = new Product(id, price);
        inventory.addProduct(product, quantity);
        return product;
    }

    public void selectProduct(Product product) {
        vendingMachineState.selectProduct(product);
    }

    public void insertNote(Note note) {
        vendingMachineState.insertNote(note);
    }

    public void dispenseProduce() {
        vendingMachineState.dispenseProduct();
    }

    public void returnChange() {
        vendingMachineState.returnChange();
    }

    public void changeState(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    void addNote(Note note) {
        totalPayment+=note.amount;
    }

    void setState(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }
}
