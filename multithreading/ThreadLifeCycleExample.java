package multithreading;

class MyTask implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + "is running...");
    }

}

class Shared {
    public synchronized void work() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadLifeCycleExample {
    public static void main(String[] args) throws InterruptedException {
        // NEW → RUNNABLE → (BLOCKED / WAITING / TIMED_WAITING) → RUNNABLE → TERMINATED
        MyTask m1 = new MyTask();
        Thread t = new Thread(m1, "worker-1");
        // NEW
        System.out.println(t.getState());
        t.start();
        // RUNNABLE
        System.out.println(t.getState());
        Shared obj = new Shared();
        Thread t1 = new Thread(() -> obj.work(), "worker-2");
        Thread t2 = new Thread(() -> obj.work(), "worker-3");

        t1.start();
        Thread.sleep(1000);
        t2.start();
        Thread.sleep(1000);

        System.out.println(t2.getState());

        // WAITING
        // TIMED_WAITING
        Thread t3 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread t4 = new Thread(() -> {
            try {
                t1.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        t3.start();
        t4.start();
        Thread.sleep(100);
        System.out.println(t3.getState());
        System.out.println(t4.getState());

        // TERMINATED
        Thread t5 = new Thread(() -> {
            System.out.println("Done");
        });

        t5.start();
        t5.join();

        System.out.println(t5.getState());

    }
}
