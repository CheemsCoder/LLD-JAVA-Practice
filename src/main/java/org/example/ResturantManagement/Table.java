package org.example.ResturantManagement;

public class Table {
    Integer tableNumber;
    Integer capacity;
    Boolean isAvailable;


    public Table(Integer tableNumber, Integer capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.isAvailable = true;
    }

    public synchronized void reserve() {
        if (!isAvailable) throw new IllegalStateException("Table already reserved");
        isAvailable = false;
    }

    public synchronized void release() {
        isAvailable = true;
    }



}
