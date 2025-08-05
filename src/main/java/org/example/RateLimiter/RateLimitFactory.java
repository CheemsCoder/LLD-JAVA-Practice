package org.example.RateLimiter;

import java.util.concurrent.TimeUnit;

public class RateLimitFactory {
    public static IRateLimiter createRateLimiter(String type, int limit, long windowSizeMillis) {
        switch (type) {
            case "fixed": {
                return new FixedWindowRateLimiter(limit, windowSizeMillis);
            }
            case "sliding": {
                return new SlidingWindowRateLimiter(limit, windowSizeMillis);
            }
            case "token-bucket": {
                return new TokenBucketRateLimiter(limit, (1.0 * limit / windowSizeMillis * 1000));
            }
            case "leaky-bucket": {
                long leakIntervalMillis = windowSizeMillis / limit;
                return new LeakyBucketRateLimiter(limit, TimeUnit.MILLISECONDS.toSeconds(leakIntervalMillis));
            }
            default: {
                throw new IllegalArgumentException("Unsupported type: " + type);
            }
        }
    }
}
