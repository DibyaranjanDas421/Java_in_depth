package interview_question;

import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCache<K, V> {
    class CacheEntry {
        V value;
        long expiryTime;

        CacheEntry(V value, int ttlMillis) {
            this.value = value;
            this.expiryTime = System.currentTimeMillis() + ttlMillis;
        }

        boolean isExpired() {
            return System.currentTimeMillis() > expiryTime;
        }

    }

    private final ConcurrentHashMap<K, CacheEntry> cache;

    public InMemoryCache() {
        cache = new ConcurrentHashMap<>();
    }

    public void put(K key, V value, int ttlMillis) {
        CacheEntry entry = new CacheEntry(value, ttlMillis);
        cache.put(key, entry);

    }

    public V get(K key) {

        CacheEntry entry = cache.get(key);

        if (entry == null) {
            return null;
        }

        if (entry.isExpired()) {

            cache.remove(key);

            return null;
        }

        return entry.value;
    }

    public void remove(K key) {
        cache.remove(key);
    }

    public int size() {
        return cache.size();
    }

    public static void main(String[] args) throws Exception {

        InMemoryCache<Integer, String> cache = new InMemoryCache<>();

        cache.put(1, "User-A", 5000);

        System.out.println(cache.get(1));

        Thread.sleep(6000);

        System.out.println(cache.get(1));
    }

}
