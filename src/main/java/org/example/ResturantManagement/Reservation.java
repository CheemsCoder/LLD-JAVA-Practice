package org.example.ResturantManagement;

import java.sql.Timestamp;
import java.util.UUID;

public class Reservation {
    String id;
    Table table;
    Customer customer;
    Timestamp reservationTIme;

    public Reservation(Table table, Customer customer, Timestamp reservationTIme) {
        this.id = UUID.randomUUID().toString();
        this.table = table;
        this.customer = customer;
        this.reservationTIme = reservationTIme;
    }
}
