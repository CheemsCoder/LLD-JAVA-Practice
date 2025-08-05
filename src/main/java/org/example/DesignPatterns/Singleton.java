package org.example.DesignPatterns;

/*
    Singleton Design Pattern

    Purpose: Ensure only one instance of the class exists and provide global access to it.

    Components:
    1. Private static instance: Holds the unique instance of the class.
    2. Private constructor: Prevents other classes from creating instances directly.
    3. Global access method: Provides access to the single instance (e.g., getInstance()).

    Usage: Commonly used for shared resources like logging, database connections, configuration management.
*/

public class Singleton {

    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) { // Double-checked locking
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void displayMessage() {
        System.out.println("Singleton Instance: " + this);
    }

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        singleton1.displayMessage();
        singleton2.displayMessage();

        System.out.println("Are both instances the same? " + (singleton1 == singleton2));  // true
    }
}

