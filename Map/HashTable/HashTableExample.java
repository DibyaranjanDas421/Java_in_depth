package Map.HashTable;

import java.util.HashMap;
import java.util.Hashtable;

public class HashTableExample {

    public static void main(String[] args) {

        // Thread-safe example
        // HashMap<Integer, Integer> map = new HashMap<>(); loop runs 200 times result
        // 120

        Hashtable<Integer, Integer> map = new Hashtable<>();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                map.put(i, i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 100; i < 200; i++) {
                map.put(i, i);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(map.size());

    }

}
