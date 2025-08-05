package org.example.Kafka;

import java.util.*;

public class Topic implements ITopic {
    String topicId;
    List<Message> messages;
    public Topic(String topicId) {
        this.topicId = topicId;
        this.messages = new ArrayList<>();
    }
    @Override
    public void addMessage(final Message msg) {
        messages.add(msg);
    }
}
