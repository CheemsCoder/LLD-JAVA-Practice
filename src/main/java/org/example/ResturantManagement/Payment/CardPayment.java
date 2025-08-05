package org.example.ResturantManagement.Payment;

public class CardPayment implements Payment {
    @Override
    public boolean processPayment(final double amount) {
        System.out.println("Processing credit card payment for amount: " + amount);
        return true;
    }
}
