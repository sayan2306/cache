import cache.Cache;
import policy.EvictionPolicy;
import policy.LRUEvictionPolicy;
import storage.HashMapStorage;
import storage.Storage;

public class Main {
    public static void main(String[] args) {
        Storage<String, String> storage = new HashMapStorage<String, String>(3);
        EvictionPolicy<String> evictionPolicy = new LRUEvictionPolicy<String>();

        Cache<String, String> cache= new Cache<String, String>(evictionPolicy, storage);

        try {
            cache.put("Key1", "Val1");

            cache.put("Key2", "Val2");


            cache.put("Key3", "Val3");

            System.out.println(storage);

            cache.put("Key1", "Val1");

            cache.put("Key4", "Val4");

            System.out.println(storage);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
