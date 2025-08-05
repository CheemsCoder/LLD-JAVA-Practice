package org.example.Cache.Storage;

import java.util.HashMap;
import java.util.Map;

import org.example.Cache.Exceptions.*;

public class HashMapStorage<Key,Value> implements Storage<Key,Value> {
    private final Map<Key, Value> storage;
    private final Integer capacity;

    public HashMapStorage(Integer capacity) {
        this.storage = new HashMap<>();
        this.capacity = capacity;
    }

    @Override
    public void add(final Key key, final Value value) throws StorageFullException {
        if(storageFull()) {
            throw new StorageFullException("Storage full");
        }
        storage.put(key, value);
    }

    @Override
    public void remove(final Key key) {
        if(storage.containsKey(key)) {
            storage.remove(key);
        }
    }

    @Override
    public Value get(final Key key) throws KeyNotFoundException {
        if(!storage.containsKey(key)) {
            throw new KeyNotFoundException("Key not found: " + key);
        }
        return storage.get(key);
    }

    private boolean storageFull() {
        if(storage.size() >= capacity)
            return true;
        return false;
    }


}
