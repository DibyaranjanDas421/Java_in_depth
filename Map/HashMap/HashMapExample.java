package Map.HashMap;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(31, "Dibya");
        map.put(11, "Ankeet");
        map.put(2, "Debu");
        // map.put(null, "Sikha");

        System.out.println(map);

        System.out.println(map.get(null));

        System.out.println(map.containsKey(2));
        System.out.println(map.containsValue("Debu"));

        // iteration
        for (int i : map.keySet()) {
            System.out.println(map.get(i));
        }

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println(map.containsKey(2));
        System.out.println(map.containsValue("Dibya"));

    }
}
