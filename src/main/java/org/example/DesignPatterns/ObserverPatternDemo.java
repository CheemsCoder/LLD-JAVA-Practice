package org.example.DesignPatterns;

/*
    Observer Design Pattern

    Purpose: When an object (Subject) changes state, all its dependents (Observers) are notified.
    Use Case: Implementing event systems like a news agency notifying subscribers.
*/

import java.util.*;

// Observer interface
interface Subscriber {
    void update(String news);
}

// Concrete observers
class EmailSubscriber implements Subscriber {
    private String name;

    public EmailSubscriber(String name) {
        this.name = name;
    }

    public void update(String news) {
        System.out.println(name + " received news via Email: " + news);
    }
}

class SmsSubscriber implements Subscriber {
    private String name;

    public SmsSubscriber(String name) {
        this.name = name;
    }

    public void update(String news) {
        System.out.println(name + " received news via SMS: " + news);
    }
}

// Subject
class NewsAgency {
    private List<Subscriber> subscribers = new ArrayList<>();
    private String news;

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void setNews(String news) {
        this.news = news;
        notifyAllSubscribers();
    }

    private void notifyAllSubscribers() {
        for (Subscriber s : subscribers) {
            s.update(news);
        }
    }
}

// Client
public class ObserverPatternDemo {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        Subscriber john = new EmailSubscriber("John");
        Subscriber alice = new SmsSubscriber("Alice");

        agency.addSubscriber(john);
        agency.addSubscriber(alice);

        agency.setNews("New Java version released!");
        agency.setNews("Observer pattern is awesome!");
    }
}

