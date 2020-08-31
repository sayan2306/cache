package storage;

import exception.KeyNotFoundException;
import exception.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorage<K, V> implements Storage<K, V> {
    private Map<K, V> storage;
    private int capacity;

    public HashMapStorage(int capacity) {
        this.capacity = capacity;
        this.storage = new HashMap<K, V>();
    }

    public void add(K key, V value) throws StorageFullException {
        if(this.isFull()) throw new StorageFullException();
        storage.put(key, value);
    }

    public V get(K key) throws KeyNotFoundException {
        if(!storage.containsKey(key)) throw new KeyNotFoundException();
        return storage.get(key);
    }

    public void remove(K key) throws KeyNotFoundException {
        if(!storage.containsKey(key)) throw new KeyNotFoundException();
        storage.remove(key);
    }

    public boolean isFull() {
        return storage.size() == this.capacity;
    }

    public String toString() {
        return storage.toString();
    }
}
