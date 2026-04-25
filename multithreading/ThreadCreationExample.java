package multithreading;

class Worker implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }

}

public class ThreadCreationExample extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        ThreadCreationExample t1 = new ThreadCreationExample();
        t1.start();
        Worker w1 = new Worker();
        Thread t2 = new Thread(w1);

        t2.start();

    }
}
