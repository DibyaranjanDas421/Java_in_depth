package Map.IdentityHashMap;

import java.util.HashMap;
import java.util.IdentityHashMap;

public class IdentityHashMapExample {

    public static void main(String[] args) {

        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put(new String("key"), 20);
        map1.put(new String("key"), 30);

        System.out.println(map1);
        IdentityHashMap<String, Integer> ih = new IdentityHashMap<>();

        ih.put(new String("Dibya"), 7);
        ih.put(new String("Dibya"), 8);

        System.out.println(ih);
    }
}
