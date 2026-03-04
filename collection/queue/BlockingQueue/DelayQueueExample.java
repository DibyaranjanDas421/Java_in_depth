package collection.queue.BlockingQueue;

import java.util.concurrent.*;

public class DelayQueueExample {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedTask> queue = new DelayQueue<>();

        queue.put(new DelayedTask("Task1", 5));
        queue.put(new DelayedTask("Task2", 2));
        queue.put(new DelayedTask("Task3", 8));

        while (!queue.isEmpty()) {
            System.out.println("Taking: " + queue.take());
        }
    }
}

class DelayedTask implements Delayed {

    private String name;
    private long startTime;

    public DelayedTask(String name, long delayInSeconds) {
        this.name = name;
        this.startTime = System.currentTimeMillis()
                + delayInSeconds * 1000;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long remaining = startTime - System.currentTimeMillis();
        return unit.convert(remaining, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed other) {
        return Long.compare(
                this.getDelay(TimeUnit.MILLISECONDS),
                other.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public String toString() {
        return name;
    }
}