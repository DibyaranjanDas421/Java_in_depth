package collection.set;

import java.util.HashSet;
import java.util.Set;

public class SetExamples {

    public static void main(String[] args) {
        // same as Hashmap and here values are dumy
        Set<Integer> set = new HashSet<>();
        set.add(76);
        set.add(3);
        set.add(4);
        set.add(9);
        System.out.println(set);
        // set-HashSet,LinkedHashSet,TreeSet,EnumSet(not synchronized)
        // map-HashMap,LinkedHashMap,TreeMap,EnumMap
        // ConcurrentSkipListSet,CopyOnWriteArraySet
    }

}
