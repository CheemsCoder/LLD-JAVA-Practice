package org.example.LoggingSystem;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.info("Hello World");
        logger.debug("Hello World");
    }
}
