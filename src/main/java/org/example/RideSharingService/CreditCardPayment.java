package org.example.RideSharingService;

public class CreditCardPayment implements Payment {
    @Override
    public void process(final Integer amount) {
        System.out.println("Processing " + amount + " credit cards");
    }
}
