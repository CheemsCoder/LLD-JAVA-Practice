package org.example.NotificationSystem;

public class Main {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        service.registerChannel(new EmailNotification());
        service.registerChannel(new SMSNotification());

        service.sendNotification("Your order has shipped!");
    }
}
