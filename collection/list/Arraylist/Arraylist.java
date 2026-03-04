package collection.list.Arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Arraylist {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        // add
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        System.out.println(list);
        System.out.println(list.size());
        // add index
        list.add(3, "E");
        System.out.println(list);
        // replace
        list.set(0, "F");
        System.out.println(list);
        // check present or not
        System.out.println(list.contains("A"));

        // iteration
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        for (String x : list) {
            System.out.println(x);
        }

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // Arrays.asList()
        // ArrayList<String> list1= Arrays.asList("A","B","C");--returns a list of fixed
        // size satic arraylist ineer class inside arrays
        List<String> list1 = Arrays.asList("A", "B", "C");
        // list1.add("E");-- can't add also as it is fixed size in nature
        System.out.println(list1);
        list1.set(0, "Z"); // can replace
        System.out.println(list1);

        // imutable list
        List<Integer> list3 = List.of(1, 2, 15, 4, 5); // intriduced in java 9
        // list3.add(6); --can't add
        // list3.set(1, 10); -- can't replace also

        // sorting
        list1.sort(null); // natural ordering
        System.out.println(list1);

        Collections.sort(list);
        System.out.println(list);

    }

}
