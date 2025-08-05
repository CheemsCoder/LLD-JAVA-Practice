package org.example.Kafka;

public class Producer {
    String name;
    IQueueMediator queueMediator;

    public Producer(String name, IQueueMediator queueMediator) {
        this.name = name;
        this.queueMediator = queueMediator;
    }

    public void publish(Message message, String topicId) {
        queueMediator.publishToTopic(topicId, message);
    }
}
