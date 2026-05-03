package multithreading.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureBasic {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(
                    Thread.currentThread().getName());

            return "Hello";
        });

        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {

            System.out.println("Running...");
        });

        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> "Java")
                .thenApply(str -> str.length());

        CompletableFuture<Void> future4 = CompletableFuture.supplyAsync(() -> "Java")
                .thenAccept(str -> {
                    System.out.println(str);
                });

        CompletableFuture<Void> future5 = CompletableFuture.supplyAsync(() -> "Task")
                .thenRun(() -> {
                    System.out.println("completed");
                });

        CompletableFuture<Void> future6 = CompletableFuture.supplyAsync(() -> 10)
                .thenApply(n -> n * 2)
                .thenApply(n -> n * 3)
                .thenAccept(System.out::println);

        CompletableFuture<String> future7 = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(user -> CompletableFuture.supplyAsync(() -> user + "profile"));

        CompletableFuture<String> user = CompletableFuture.supplyAsync(() -> "User");

        CompletableFuture<String> orders = CompletableFuture.supplyAsync(() -> "Orders");

        CompletableFuture<String> payments = CompletableFuture.supplyAsync(() -> "Payments");
        CompletableFuture<Void> all =

                CompletableFuture.allOf(
                        user,
                        orders,
                        payments);

        all.join();

        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "Hello ");

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<String> combined =

                f1.thenCombine(f2,
                        (a, b) -> a + b);

        System.out.println(combined.join());

        System.out.println(user.join());
        System.out.println(orders.join());
        System.out.println(payments.join());

        System.out.println(future.join());
        System.out.println(future1.join());
        System.out.println(future3.join());
        System.out.println(future4.join());
        System.out.println(future7.join());

        CompletableFuture<Integer> future8 =

                CompletableFuture.supplyAsync(() -> {

                    return 10 / 0;

                }).exceptionally(ex -> {

                    System.out.println(ex);

                    return 0;
                });

        System.out.println(future8.join());

        ExecutorService executor = Executors.newFixedThreadPool(5);

        CompletableFuture<String> future9 =

                CompletableFuture.supplyAsync(() -> {

                    return "Task";

                }, executor);

        System.out.println(future9.join());

        executor.shutdown();
    }

}
