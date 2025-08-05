package org.example.NotificationSystem;

import java.util.*;

public class NotificationService {
    private List<INotification> channels;

    public NotificationService() {
        channels = new ArrayList<>();
    }

    public void registerChannel(INotification channel) {
        channels.add(channel);
    }

    public void sendNotification(String message) {
        for (INotification channel : channels) {
            channel.notify(message);
        }
    }
}

