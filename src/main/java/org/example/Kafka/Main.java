package org.example.Kafka;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        QueueMediator queueMediator = new QueueMediator();

        Topic t1 = new Topic("topic1");
        Topic t2 = new Topic("topic2");
        Topic t3 = new Topic("topic3");

        queueMediator.addTopic(t1);
        queueMediator.addTopic(t2);
        queueMediator.addTopic(t3);

        Producer producer1 = new Producer("P1", queueMediator);
        Producer producer2 = new Producer("P2", queueMediator);

        Consumer consumer1 = new Consumer("C1", queueMediator);
        Consumer consumer2 = new Consumer("C2", queueMediator);
        Consumer consumer3 = new Consumer("C3", queueMediator);

        consumer1.subToTopic("topic1");
        consumer2.subToTopic("topic2");
        consumer3.subToTopic("topic3");

        Thread tC1 = new Thread(consumer1);
        Thread tC2 = new Thread(consumer2);
        Thread tC3 = new Thread(consumer3);

        tC1.start();
        tC2.start();
        tC3.start();

        // Simulate publishing messages
        Thread.sleep(1000);
        producer1.publish(new Message("Msg1 to topic1"), "topic1");
        Thread.sleep(500);
        producer2.publish(new Message("Msg2 to topic2"), "topic2");
        Thread.sleep(500);
        producer1.publish(new Message("Msg3 to topic3"), "topic3");
        Thread.sleep(500);
        producer2.publish(new Message("Msg4 to topic1"), "topic1");

        // Let consumers run for a while
        Thread.sleep(3000);

        // Graceful shutdown
        consumer1.stop();
        consumer2.stop();
        consumer3.stop();
        tC1.join();
        tC2.join();
        tC3.join();

        System.out.println("All consumers stopped.");
    }
}
