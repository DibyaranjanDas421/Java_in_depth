package collection.queue.ConcurrentLinkedDeque;

import java.util.concurrent.ConcurrentLinkedDeque;

public class CLDThreadExample {

    public static void main(String[] args) {

        ConcurrentLinkedDeque<Integer> deque = new ConcurrentLinkedDeque<>();

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                deque.offerLast(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                while (deque.pollFirst() == null) {
                }
            }
        });

        t1.start();
        t2.start();
    }
}