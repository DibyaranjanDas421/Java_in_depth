package Map.LinkedHashMap;

import java.util.LinkedHashMap;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {

        LRUCache<Integer, String> lru = new LRUCache<>(3);
        lru.put(1, "Dibya");
        lru.put(2, "Anket");
        lru.put(3, "Debu");
        lru.put(4, "Soumya");
        lru.get(2);

        System.out.println(lru);
    }

}
