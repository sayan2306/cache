package cache;

import exception.KeyNotFoundException;
import exception.StorageFullException;
import policy.EvictionPolicy;
import storage.Storage;

public class Cache<K, V> {
    EvictionPolicy<K> policy;
    Storage<K, V> storage;

    public Cache(EvictionPolicy policy, Storage storage) {
        this.policy = policy;
        this.storage = storage;
    }

    public V get(K key) throws Exception {
        this.policy.keyAccessed(key);
        return this.storage.get(key);
    }

    public void put(K key, V value) throws Exception{
        try {
            this.policy.keyAccessed(key);
            this.storage.add(key, value);
        } catch(StorageFullException e) {
            K keyToEvict = this.policy.evictKey();
            if (keyToEvict == null) {
                throw new RuntimeException("Storage full and no key to evict. Report a bug.");
            }
            this.storage.remove(keyToEvict);
            System.out.println("Evicting key from cache.");
            this.put(key, value);
        }
    }
}
