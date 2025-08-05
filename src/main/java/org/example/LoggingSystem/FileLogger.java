package org.example.LoggingSystem;

public class FileLogger implements LogObserver {
    @Override
    public void log(final String message) {
        System.out.println("Logging to file: " + message);
    }
}
