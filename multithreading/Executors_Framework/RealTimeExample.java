package multithreading.Executors_Framework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RealTimeExample {
    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<String> task1 = () -> {

            Thread.sleep(2000);

            return "Database Result";
        };

        Callable<String> task2 = () -> {

            Thread.sleep(1000);

            return "API Result";
        };

        Future<String> future1 = executor.submit(task1);

        Future<String> future2 = executor.submit(task2);

        System.out.println("Main thread continues...");

        System.out.println(future1.get());
        System.out.println(future2.get());

        executor.shutdown();
    }
}
