package org.example.ResturantManagement.Payment;

public class UPIPayment  implements Payment{
    @Override
    public boolean processPayment(final double amount) {
        System.out.println("Processing upi payment for amount: " + amount);
        return true;
    }
}
