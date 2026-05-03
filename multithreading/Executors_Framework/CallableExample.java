package multithreading.Executors_Framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<Integer> future = executorService.submit(() -> {
            int x = 10 / 0;
            return x;
        });

        try {
            future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        executorService.shutdown();

    }

}
