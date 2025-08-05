package org.example.NotificationSystem;

public class SMSNotification implements INotification {
    @Override
    public void notify(final String message) {
        System.out.println("Sending SMS: " + message);
    }
}
