package org.example.RateLimiter;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class FixedWindowRateLimiter implements IRateLimiter{
    private Long windowInMill;
    private Integer limit;
    private Map<String, Integer> requestCount;
    private Map<String, Long> startTime;

    public FixedWindowRateLimiter(Integer limit, Long windowInMill) {
        this.windowInMill = windowInMill;
        this.limit = limit;
        this.requestCount = new ConcurrentHashMap<>();
        this.startTime = new ConcurrentHashMap<>();
    }

    @Override
    public synchronized Boolean acceptRequest(final String clientId) {
        if(!requestCount.containsKey(clientId) || requestCount.get(clientId) == 0) {
            startTime.put(clientId, System.currentTimeMillis());
            return true;
        }
        Long currentTime = System.currentTimeMillis();
        if(currentTime - startTime.get(clientId) > windowInMill) {
            requestCount.remove(clientId);
            startTime.put(clientId, currentTime);
        }
        Integer count = requestCount.get(clientId);
        if(count >= limit ) {
            System.out.println("Request has been rate limited");
            return false;
        }
        requestCount.put(clientId, requestCount.getOrDefault(clientId, 0) + 1);
        return true;
    }
}
