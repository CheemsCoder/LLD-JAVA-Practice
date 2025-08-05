package org.example.DesignPatterns;

/*
    Strategy Design Pattern

    Purpose: Encapsulate interchangeable behaviors (algorithms) and allow selecting them at runtime.
    Use Case: Dynamically choosing between payment methods (Credit Card, PayPal, etc.).
*/

// Strategy interface
interface PaymentStrategy {
    void pay(double amount);
}

// Concrete strategies
class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal");
    }
}

class UpiPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using UPI");
    }
}

// Context class
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(double amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment method not set.");
        }
        paymentStrategy.pay(amount);
    }
}

// Client
public class StrategyPatternDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(100.0);

        cart.setPaymentStrategy(new PayPalPayment());
        cart.checkout(250.0);

        cart.setPaymentStrategy(new UpiPayment());
        cart.checkout(75.0);
    }
}

