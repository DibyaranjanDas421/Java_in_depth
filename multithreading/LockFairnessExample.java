package multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class LockFairnessExample {
    public static void main(String[] args) {
        Task t = new Task();

        Thread t1 = new Thread(() -> {
            t.doTask();
        }, "worker-1");

        Thread t2 = new Thread(() -> {
            t.doTask();
        }, "worker-2");

        Thread t3 = new Thread(() -> {
            t.doTask();
        }, "worker-3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Task {

    private final ReentrantLock lock = new ReentrantLock(true);

    public void doTask() {
        lock.lock();

        try {
            System.out.println(Thread.currentThread().getName() + " got lock");

        } finally {
            lock.unlock();
        }

    }

}
