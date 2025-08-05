package org.example.RateLimiter;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

// Refills token at a fixed rate
// Has a max capacity
// Keeps logs of refill
public class TokenBucketRateLimiter implements IRateLimiter{
    private Double numberOfTokens;
    private Integer capacity;
    private Map<String , Long> refillHistory;
    private Map<String, Integer> tokensLeft;

    public TokenBucketRateLimiter(Integer capacity, Double numberOfTokens) {
        this.capacity = capacity;
        this.numberOfTokens = numberOfTokens;
        this.refillHistory = new ConcurrentHashMap<>();
        this.tokensLeft = new ConcurrentHashMap<>();
    }
    @Override
    public synchronized Boolean acceptRequest(final String clientId) {
        Long currentTime = System.currentTimeMillis();
        refillHistory.putIfAbsent(clientId, currentTime);
        tokensLeft.putIfAbsent(clientId, capacity);
        Long elapsedTime = (currentTime - refillHistory.get(clientId))/1000;
        if(elapsedTime > 0) {
            Integer count = Math.min(capacity, tokensLeft.get(clientId) +(int)(elapsedTime * numberOfTokens));
            tokensLeft.put(clientId, count);
        }
        if(tokensLeft.get(clientId) > 0) {
            tokensLeft.put(clientId, tokensLeft.get(clientId) - 1);
            return true;
        }
        return false;
    }
}
