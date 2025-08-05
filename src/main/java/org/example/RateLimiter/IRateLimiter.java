package org.example.RateLimiter;

public interface IRateLimiter {
    Boolean acceptRequest(String clientId);
}
