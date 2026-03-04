package Map.ConcurrentSkipListMap;

import java.util.Comparator;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapExample {

    public static void main(String[] args) {

        ConcurrentSkipListMap<String, Integer> map = new ConcurrentSkipListMap<>(Comparator.reverseOrder());
        map.put("B", 1);
        map.put("A", 2);
        map.put("C", 3);

        System.out.println(map);

    }
}
