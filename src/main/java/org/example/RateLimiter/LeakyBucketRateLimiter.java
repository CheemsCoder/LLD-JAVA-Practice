package org.example.RateLimiter;

import java.util.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


// LeakyBucket
// Fixed interval request is processed
public class LeakyBucketRateLimiter implements IRateLimiter{
    private Integer capacity;
    private List<String> bucket;
    private Long leakRateSec;
    private ScheduledExecutorService scheduledExecutorService;
    public LeakyBucketRateLimiter(Integer capacity, Long leakRateSec) {
        this.capacity = capacity;
        this.leakRateSec = leakRateSec;
        this.bucket = Collections.synchronizedList(new ArrayList<>());
        scheduledExecutorService = new ScheduledThreadPoolExecutor(1);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(!bucket.isEmpty()) {
                    bucket.remove(0);
                }
            }
        };
        try{
            scheduledExecutorService.schedule(runnable, leakRateSec, TimeUnit.SECONDS);
        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    @Override
    public synchronized Boolean acceptRequest(final String clientId) {
        Long currentTime = System.currentTimeMillis();
        if(bucket.size() < capacity) {
            bucket.add(clientId);
            return true;
        }
        return false;
    }

    public void shutDown() {
        scheduledExecutorService.shutdown();
    }
}
