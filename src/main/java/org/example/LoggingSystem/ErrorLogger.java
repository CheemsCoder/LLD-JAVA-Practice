package org.example.LoggingSystem;

public class ErrorLogger extends LogHandler {
    public ErrorLogger(LogLevel level) {
        this.logLevel = level;
    }
    @Override
    public void publishLog(final String message, final LogSinkSubject logSinkSubject) {
        String msg = "ERROR: " + message;
        logSinkSubject.notifyObservers(logLevel, msg);
    }
}
