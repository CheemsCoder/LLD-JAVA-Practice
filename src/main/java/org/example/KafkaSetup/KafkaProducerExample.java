package org.example.KafkaSetup;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class KafkaProducerExample {
    public static void main(String[] args) {
        // Producer config
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // Create producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        // Create record
        ProducerRecord<String, String> record = new ProducerRecord<>("test-topic", "key2", "Hello"
                + "!");

        // Send record
        producer.send(record, (metadata, exception) -> {
            if (exception == null) {
                System.out.println("Message sent successfully:");
                System.out.println("  Topic: " + metadata.topic());
                System.out.println("  Partition: " + metadata.partition());
                System.out.println("  Offset: " + metadata.offset());
            } else {
                exception.printStackTrace();
            }
        });

        producer.flush();
        producer.close();
    }
}
