package multithreading;

import java.util.concurrent.CyclicBarrier;

public class CycelicBaarrierExample {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        Runnable runnable = () -> {
            try {
                System.out.println(
                        Thread.currentThread().getName()
                                + " working");

                Thread.sleep(
                        (long) (Math.random() * 3000));

                System.out.println(
                        Thread.currentThread().getName()
                                + " waiting at barrier");

                cyclicBarrier.await();

                System.out.println(
                        Thread.currentThread().getName()
                                + " crossed barrier");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

}
