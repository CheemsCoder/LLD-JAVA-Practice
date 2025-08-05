package org.example.LoggingSystem;

public class LogManager {
    public static LogHandler buildLoggerChain() {
        LogHandler info = new InfoLogger(LogLevel.INFO);
        LogHandler debug = new DebugLogger(LogLevel.DEBUG);
        LogHandler error = new ErrorLogger(LogLevel.ERROR);
        debug.setNextHandler(error);
        error.setNextHandler(info);
        return debug;
    }

    public static LogSinkSubject buildLogSinkSubject() {
        LogSinkSubject logSinkSubject = new LogSinkSubject();
        logSinkSubject.add(LogLevel.INFO, new FileLogger());
        logSinkSubject.add(LogLevel.DEBUG, new FileLogger());
        logSinkSubject.add(LogLevel.DEBUG, new DatabaseLogger());
        return logSinkSubject;
    }

}
