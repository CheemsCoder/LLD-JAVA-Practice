package org.example.Cache;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.example.Cache.Eviction.EvictionPolicy;
import org.example.Cache.Eviction.LRUEvictionPolicy;
import org.example.Cache.Exceptions.KeyNotFoundException;
import org.example.Cache.Exceptions.StorageFullException;
import org.example.Cache.Storage.HashMapStorage;
import org.example.Cache.Storage.Storage;

import java.util.*;

public class Cache<Key,Value> {
    private final ScheduledExecutorService cleaner = Executors.newSingleThreadScheduledExecutor();
    private final Storage<Key,Value> storage;
    private final EvictionPolicy<Key> evictionPolicy;
    private final Map<Key, Long> expiryMap = new HashMap<>();

    public Cache(final Storage<Key, Value> storage,
            final EvictionPolicy<Key> evictionPolicy) {
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
        startCleaner();
    }

    private void startCleaner() {
        cleaner.scheduleAtFixedRate(()->{
            long now = System.currentTimeMillis();
            for(Key key : expiryMap.keySet()) {
                if(expiryMap.get(key) <= now) {
                    storage.remove(key);
                    expiryMap.remove(key);
                    System.out.println("Cleaner evicted key " + key);
                }
            }
        }, 1, 1, TimeUnit.SECONDS);
    }

    public Value get(final Key key) {
        if (isExpired(key)) {
            System.out.println("Key " + key + " has expired.");
            storage.remove(key);
            expiryMap.remove(key);
            return null;
        }
        try {
            Value value = storage.get(key);
            evictionPolicy.keyAccessed(key);
            return value;
        } catch (KeyNotFoundException e) {
            System.out.println("Hit a cache miss  for key " + key);
        }
        return null;
    }

    private boolean isExpired(Key key) {
        if (!expiryMap.containsKey(key)) return false;
        return System.currentTimeMillis() > expiryMap.get(key);
    }

    public void put(final Key key, final Value value, long ttl) {
        long expiry = System.currentTimeMillis() + ttl;
        expiryMap.put(key, expiry);
        try {
            storage.add(key, value);
            evictionPolicy.keyAccessed(key);
        } catch (StorageFullException e) {
            System.out.println("Got storage full! Trying to evict");
            Key keyToBeRemoved = evictionPolicy.evict();
            storage.remove(keyToBeRemoved);
            System.out.println("Evicting key " + keyToBeRemoved);
            put(key, value, ttl);
        }
    }
}
