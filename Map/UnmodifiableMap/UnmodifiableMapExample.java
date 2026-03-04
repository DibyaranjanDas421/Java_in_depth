package Map.UnmodifiableMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UnmodifiableMapExample {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("Dibya", 80);
        map.put("Soumya", 90);
        map.put("Ankeet", 100);
        map.put("Debu", 99);

        Map<String, Integer> map2 = Collections.unmodifiableMap(map);
        // map2.put("Rohit", 98); can't add

        Map<String, Integer> map3 = Map.of("Dibya", 98, "Ankeet", 99); // this also unmodifiable but highest 10 entriees

        Map<String, Integer> map4 = Map.ofEntries(Map.entry("Dibya", 80), Map.entry("Ankeet", 85)); // here we can add
                                                                                                    // multiple entries

    }

}
