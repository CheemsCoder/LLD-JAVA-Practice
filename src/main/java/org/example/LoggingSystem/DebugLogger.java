package org.example.LoggingSystem;

public class DebugLogger extends LogHandler {
    public DebugLogger(LogLevel level) {
        this.logLevel = level;
    }
    @Override
    public void publishLog(final String message, final LogSinkSubject logSinkSubject) {
        String msg = "DEBUG: " + message;
        logSinkSubject.notifyObservers(logLevel, msg);
    }
}
