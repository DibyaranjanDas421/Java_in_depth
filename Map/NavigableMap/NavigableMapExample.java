package Map.NavigableMap;

import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapExample {

    public static void main(String[] args) {
        NavigableMap<Integer, String> map = new TreeMap<>();

        map.put(10, "A");
        map.put(20, "B");
        map.put(30, "C");
        map.put(40, "D");

        System.out.println("lowerKey(25): " + map.lowerKey(25));
        System.out.println("floorKey(20): " + map.floorKey(20));
        System.out.println("ceilingKey(25): " + map.ceilingKey(25));
        System.out.println("higherKey(20): " + map.higherKey(20));
    }

}
