package collection.queue.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder()); // you can give custom
                                                                                       // comparator(30,15,10,5)

        queue.add(5);
        queue.add(15);
        queue.add(10);
        queue.add(30);
        System.out.println(queue);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll()); // 5,10,15,30
        }

        // Internally used mean-heap algo
    }

}
