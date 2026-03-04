package collection.queue.ConcurrentLinkedQueue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueExample {

    public static void main(String[] args) {
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                queue.offer(i);
                System.out.println("Produced: " + i);
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                Integer val;
                while ((val = queue.poll()) == null) {
                    // spin wait
                }
                System.out.println("Consumed: " + val);
            }
        });

        producer.start();
        consumer.start();
    }
}
