package org.example.LoggingSystem;

public abstract class LogHandler {
    LogHandler nextHandler;
    LogLevel logLevel;

    public void setNextHandler(LogHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void log(LogLevel level, String message, LogSinkSubject logSinkSubject) {
        if(logLevel == level) {
            publishLog(message, logSinkSubject);
        }
        if(nextHandler != null) {
            nextHandler.log(level, message, logSinkSubject);
        }
    }

    public abstract void publishLog(String message, LogSinkSubject logSinkSubject);
}
