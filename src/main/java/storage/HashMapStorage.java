package storage;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorage<K, V> implements IStorage {
    private Map<K, V> storage;
    private int capacity;

    public HashMapStorage(int capacity) {
        this.capacity = capacity;
        this.storage = new HashMap<K, V>();
    }
}
