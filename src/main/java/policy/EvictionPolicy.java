package policy;

public interface EvictionPolicy<K> {

    public void keyAccessed(K key) throws Exception;

    public K evictKey() throws Exception;
}
