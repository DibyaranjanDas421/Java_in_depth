package multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        Runnable runnable = () -> {
            System.out.println(
                    Thread.currentThread().getName()
                            + " working");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(
                    Thread.currentThread().getName()
                            + " finished");

            countDownLatch.countDown();
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();

        System.out.println("Main waiting...");

        countDownLatch.await();
        System.out.println(
                "All workers completed");

    }
}
