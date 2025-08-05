package org.example.NotificationSystem;

public class EmailNotification implements INotification {
    @Override
    public void notify(final String message) {
        System.out.println("Email Notification : " + message);
    }
}
