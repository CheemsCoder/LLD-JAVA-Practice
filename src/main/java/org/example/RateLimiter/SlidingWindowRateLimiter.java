package org.example.RateLimiter;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowRateLimiter implements IRateLimiter {
    private Integer limit;
    private Long windowSizeInMills;
    private Map<String, List<Long>> requestLong;

    public SlidingWindowRateLimiter(Integer limit, Long windowSizeInMills) {
        this.limit = limit;
        this.windowSizeInMills = windowSizeInMills;
        this.requestLong = new ConcurrentHashMap<>();
    }

    @Override
    public synchronized Boolean acceptRequest(final String clientId) {
        Long currentTime = System.currentTimeMillis();
        List<Long> requests = requestLong.getOrDefault(clientId, new ArrayList<>());
        while(!requests.isEmpty() && currentTime - requests.get(0) > windowSizeInMills) {
            requests.remove(0);
        }
        if(requests.size() < limit) {
            requests.add(currentTime);
            requestLong.put(clientId, requests);
            return true;
        }
        return false;
    }
}
