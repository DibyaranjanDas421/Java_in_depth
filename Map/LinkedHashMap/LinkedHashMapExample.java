package Map.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {

    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>(13, 0.5f, true);
        map.put(1, "Orange");
        map.put(2, "Apple");
        map.put(3, "Mango");

        map.get("Orange");
        map.get("Mango");
        map.get("Apple");

        for (Map.Entry<Integer, String> i : map.entrySet()) {
            System.out.println(i.getKey() + ":" + i.getValue());
        }

        String res = map.getOrDefault("vipul", "No");
        System.out.println(res);

    }

}
