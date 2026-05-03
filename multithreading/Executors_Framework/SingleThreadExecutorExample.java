package multithreading.Executors_Framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i <= 5; i++) {
            int num = i;
            executorService.execute(() -> {
                System.out.println(num);
            });
        }

        executorService.shutdown();
    }
}
