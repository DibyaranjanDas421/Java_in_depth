package collection.set;

import java.util.concurrent.CopyOnWriteArraySet;

public class ConcurrentCopyOnWriteSetExample {

    public static void main(String[] args) {
        CopyOnWriteArraySet<Integer> set = new CopyOnWriteArraySet<>();
        set.add(3);
        set.add(8);
        set.add(9);
        set.add(6);

        for (Integer a : set) {
            if (a == 8) {
                set.add(10);
            }
            System.out.println(a);

        }

        System.out.println(set); // last one added is not printed because after loop it will be added to original
                                 // one

    }

}
