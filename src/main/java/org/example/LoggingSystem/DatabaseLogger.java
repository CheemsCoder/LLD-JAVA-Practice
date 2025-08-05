package org.example.LoggingSystem;

public class DatabaseLogger implements LogObserver {
    @Override
    public void log(final String message) {
        System.out.println("Logging Into database: " + message);
    }
}
