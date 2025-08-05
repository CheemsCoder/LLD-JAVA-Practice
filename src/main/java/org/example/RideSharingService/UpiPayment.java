package org.example.RideSharingService;

public class UpiPayment implements Payment {
    @Override
    public void process(final Integer amount) {
        System.out.println("Processing UPI Payment");
    }
}
