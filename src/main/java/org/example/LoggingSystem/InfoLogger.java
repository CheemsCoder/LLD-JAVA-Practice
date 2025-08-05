package org.example.LoggingSystem;

public class InfoLogger extends LogHandler {
    public InfoLogger(LogLevel level) {
        this.logLevel = level;
    }
    @Override
    public void publishLog(final String message, final LogSinkSubject logSinkSubject) {
        String msg = "INFO: " + message;
        logSinkSubject.notifyObservers(logLevel, msg);
    }
}
