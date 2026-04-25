package multithreading;

class Counter {
    private int count = 0;

    public void increament() {

        synchronized (this) {
            count++;

        }
    }

    public int getCount() {
        return count;
    }
}

public class SynchronizationExample {

    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                c.increament();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                c.increament();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(c.getCount());
    }
}
