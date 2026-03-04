package collection.list.Vector;

import java.util.ArrayList;
import java.util.Vector;

public class VectorExample {

    public static void main(String[] args) {
        Vector<Integer> list = new Vector<>();

        Thread t = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                list.add(i);
            }
        });

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                list.add(i);
            }
        });

        t.start();
        t1.start();

        try {
            t1.join();
            t.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(list.size()); // result 121 even if loop is running 200 times for ArrayList 200 for vector
        System.out.println(list.capacity()); // in arraylist you can't get capacity in vecctor you can get it
    }

}
