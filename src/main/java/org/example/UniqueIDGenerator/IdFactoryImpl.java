package org.example.UniqueIDGenerator;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IdFactoryImpl {
    private static String hostName = "";
    private static long creationTimeMillis = 0;
    private static long lastTimeMillis;
    private static long discriminator;

    public IdFactoryImpl() throws UnknownHostException {
        this.hostName = InetAddress.getLocalHost().getHostAddress();
        this.creationTimeMillis = System.currentTimeMillis();
        this.lastTimeMillis = creationTimeMillis;
    }

    public static synchronized Serializable createId() {
        String id;
        long now = System.currentTimeMillis();

        if (now == lastTimeMillis) {
            ++discriminator;
        } else {
            discriminator = 0;
        }

        // creationTimeMillis used to prevent multiple instances of the JVM
        // running on the same host returning clashing IDs.
        // The only way a clash could occur is if the applications started at
        // exactly the same time.
        id = String.format("%s-%d-%d-%d", hostName, creationTimeMillis, now, discriminator);
        lastTimeMillis = now;

        return id;
    }

    public static void main(String[] args) throws UnknownHostException {

        for (int i=0; i<1000; ++i) {
            System.err.println(createId());
        }
    }
}