package org.example.Kafka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

public class QueueMediator implements IQueueMediator {
    Map<String, Topic> topics;

    public QueueMediator() {
        this.topics = new ConcurrentHashMap<>();
    }

    @Override
    public void publishToTopic(final String topicId, final Message message) {
        // ✅ FIX: Use existing topic from the map directly
        Topic topic = topics.get(topicId);
        if (topic != null) {
            topic.addMessage(message);
        } else {
            System.out.println("Topic not found: " + topicId); // optional logging
        }
    }

    @Override
    public void addTopic(final Topic topic) {
        topics.putIfAbsent(topic.topicId, topic);
    }

    @Override
    public List<Message> readMsgIfPresent(String topicId, final Integer offset) {
        Topic topic = topics.get(topicId);
        if (topic == null) {
            System.out.println("Topic not found: " + topicId);  // ✅ FIX: null check
            return Collections.emptyList();                      // ✅ FIX: avoid NPE
        }
        synchronized (topic.messages) {
            List<Message> messageList = new ArrayList<>();
            for (int i = offset; i < topic.messages.size(); i++) {
                messageList.add(topic.messages.get(i));
            }
            return messageList;
        }
    }
}
