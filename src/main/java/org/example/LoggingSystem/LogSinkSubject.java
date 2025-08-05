package org.example.LoggingSystem;

import java.util.*;

public class LogSinkSubject {
    Map<LogLevel, List<LogObserver>> logObserverMap;
    public LogSinkSubject() {
        logObserverMap = new HashMap<>();
    }
    public void add(LogLevel level, LogObserver observer) {
        List<LogObserver> observers = logObserverMap.getOrDefault(level, new ArrayList<>());
        observers.add(observer);
        logObserverMap.put(level, observers);
    }
    public void notifyObservers(LogLevel level, String message) {
        for(LogObserver observer : logObserverMap.get(level)) {
            observer.log(message);
        }
    }
}
