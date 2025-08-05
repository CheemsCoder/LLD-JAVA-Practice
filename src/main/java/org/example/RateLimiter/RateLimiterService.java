package org.example.RateLimiter;

import java.util.*;

public class RateLimiterService {
    private Map<String, IRateLimiter> userRateLimiters;

    public RateLimiterService() {
        this.userRateLimiters = new HashMap<>();
    }

    public void registerUser(String userId, String type, int limit, Long windowSize) {
        userRateLimiters.put(userId, RateLimitFactory.createRateLimiter(type, limit, windowSize));
    }

    public boolean allowRequest(String userId) {
        IRateLimiter rateLimiter = userRateLimiters.get(userId);
        if (rateLimiter == null) {
            throw new IllegalArgumentException("User not registered");
        }
        return rateLimiter.acceptRequest(userId);
    }
}
