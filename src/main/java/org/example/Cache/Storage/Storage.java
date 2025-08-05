package org.example.Cache.Storage;

import org.example.Cache.Exceptions.KeyNotFoundException;
import org.example.Cache.Exceptions.StorageFullException;

public interface Storage<Key,Value> {
    void add(Key key,Value value) throws StorageFullException;
    void remove(Key key);
    Value get(Key key) throws KeyNotFoundException;
}
