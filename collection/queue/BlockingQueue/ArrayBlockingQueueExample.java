package collection.queue.BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ArrayBlockingQueue;

class Producer implements Runnable {

    private BlockingQueue<Integer> data;
    private Integer value = 0;

    public Producer(BlockingQueue<Integer> data) {
        this.data = data;
    }

    @Override
    public void run() {

        while (true) {
            try {
                System.out.println("Producer produced: " + value);
                data.put(value++);
                Thread.sleep(1000);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer interrupted");
            }
        }

    }

}

class Consumer implements Runnable {

    private BlockingQueue<Integer> data;

    public Consumer(BlockingQueue<Integer> data) {
        this.data = data;
    }

    @Override
    public void run() {

        while (true) {
            try {
                System.out.println("Consumer consumed: " + data.take());
                Thread.sleep(2000);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer interrupted");
            }
        }

    }

}

public class ArrayBlockingQueueExample {

    public static void main(String[] args) throws InterruptedException {

        // BlockingQueue<Integer> data = new ArrayBlockingQueue<>(5);

        // Thread t1 = new Thread(new Producer(data));
        // Thread t2 = new Thread(new Consumer(data));

        // t1.start();
        // t2.start();

        LinkedBlockingQueue<Integer> queue1 = new LinkedBlockingQueue<>(2);

        queue1.put(10);
        queue1.put(20);

        System.out.println(queue1.take());

        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

        queue.put(30);
        queue.put(10);
        queue.put(20);

        System.out.println(queue.take()); // 10
        System.out.println(queue.take()); // 20

        SynchronousQueue<String> queue3 = new SynchronousQueue<>();

        Thread producer = new Thread(() -> {
            try {
                System.out.println("Producing...");
                queue3.put("Hello");
                System.out.println("Transferred!");
            } catch (Exception e) {
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Consuming...");
                System.out.println(queue3.take());
            } catch (Exception e) {
            }
        });

        producer.start();
        consumer.start();
    }
}
