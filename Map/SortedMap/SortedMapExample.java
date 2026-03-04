package Map.SortedMap;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapExample {

    public static void main(String[] args) {
        SortedMap<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());

        map.put(1, "Dibya");
        map.put(2, "Ankeet");
        map.put(3, "Debu");
        // map.put(null, null);

        System.out.println(map);

        System.out.println(map.firstKey());

        System.out.println(map.lastKey());
        System.out.println(map.headMap(1));
        System.out.println(map.tailMap(3));

        System.out.println(map.subMap(3, 1));

    }

}
