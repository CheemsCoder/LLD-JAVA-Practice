package org.example.Cache.Factory;

import org.example.Cache.Cache;
import org.example.Cache.Eviction.LRUEvictionPolicy;
import org.example.Cache.Storage.HashMapStorage;

public class CacheFactory<Key,Value> {
    public Cache<Key, Value> defaultCache(final int capacity) {
        return new Cache<>(new HashMapStorage<Key, Value>(capacity), new LRUEvictionPolicy<Key>());
    }
}
