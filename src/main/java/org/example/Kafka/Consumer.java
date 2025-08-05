package org.example.Kafka;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Consumer implements IConsumer, Runnable {
    String name;
    QueueMediator queueMediator;
    List<Topic> topics;
    Map<String, Integer> offsets;
    volatile boolean running = true;


    public Consumer(String name, QueueMediator queueMediator) {
        this.name = name;
        this.queueMediator = queueMediator;
        this.topics = new ArrayList<>();
        this.offsets = new HashMap<>();
    }

    @Override
    public void subToTopic(final String topicId) {
        Topic topic = queueMediator.topics.get(topicId);
        if (topic != null) {
            topics.add(topic);
            offsets.putIfAbsent(topicId, 0);
        } else {
            System.out.println("Subscription failed. Topic not found: " + topicId);
        }
    }

    private void readMessages() {
        for (Topic topic : topics) {
            String topicId = topic.topicId;
            int offset = offsets.getOrDefault(topicId, 0);
            List<Message> newMessages = queueMediator.readMsgIfPresent(topicId, offset);
            for (Message message : newMessages) {
                System.out.println("Consumer " + name + " received from [" + topicId + "]: " + message.content);
                offset++;
            }
            offsets.put(topicId, offset);
        }
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while(running) {
            readMessages();
            try {
                TimeUnit.MILLISECONDS.sleep(500);  // Polling interval
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumer " + name + " interrupted");
            }
        }
        System.out.println("Consumer " + name + " stopped.");
    }
}
