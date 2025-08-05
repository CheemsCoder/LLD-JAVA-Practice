package org.example.LoggingSystem;

public class Logger {
    private static Logger instance;
    private static LogHandler logHandler = LogManager.buildLoggerChain();
    private static LogSinkSubject logSinkSubject = LogManager.buildLogSinkSubject();
    private Logger() {
    }
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void info(String message) {
        logHandler.log(LogLevel.INFO, message, logSinkSubject);
    }

    public void error(String message) {
        logHandler.log(LogLevel.ERROR, message, logSinkSubject);
    }

    public void debug(String message) {
        logHandler.log(LogLevel.DEBUG, message, logSinkSubject);
    }
}
