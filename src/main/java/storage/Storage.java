package storage;

import exception.KeyNotFoundException;
import exception.StorageFullException;

public interface Storage<K, V> {

    public void add(K key, V value) throws StorageFullException;

    public V get(K key) throws KeyNotFoundException;

    public void remove(K key) throws KeyNotFoundException;

    public boolean isFull() throws Exception;

}
