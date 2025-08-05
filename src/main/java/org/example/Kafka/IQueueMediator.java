package org.example.Kafka;

import java.util.List;

public interface IQueueMediator {
    void publishToTopic(String topicId, Message message);
    void addTopic(Topic topic);
    List<Message> readMsgIfPresent(String topicId, Integer offset);
}
