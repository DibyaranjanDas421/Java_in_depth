package multithreading;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

    public static void main(String[] args) {
        DataStore obj = new DataStore();

        // Readers
        Runnable readTask = () -> obj.read();

        // Writer
        Runnable writeTask = () -> obj.write(100);

        new Thread(readTask, "R1").start();
        new Thread(readTask, "R2").start();
        new Thread(writeTask, "W1").start();

        new Thread(readTask, "R3").start();

    }

}

class DataStore {

    private Integer data = 0;

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {

        lock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + " reading: " + data);

        } finally {
            lock.readLock().unlock();
        }
    }

    public void write(int value) {
        lock.writeLock().lock();
        try {
            data = value;
            System.out.println(Thread.currentThread().getName() + " writing: " + data);
        } finally {
            lock.writeLock().unlock();
        }
    }

}
