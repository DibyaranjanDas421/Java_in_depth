package multithreading.Executors_Framework;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleTask {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Callable<Integer>> tasks = List.of(
                () -> 10,
                () -> 20,
                () -> 30);

        List<Future<Integer>> result = executorService.invokeAll(tasks);

        for (Future<Integer> future : result) {
            System.out.println(future.get());
        }

        Integer result1 = executorService.invokeAny(tasks);

        System.out.println(result1);

        executorService.shutdown();

    }

}
