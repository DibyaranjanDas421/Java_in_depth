package multithreading.Executors_Framework;

import java.util.concurrent.Executor;

public class ExecuterExample {

    public static void main(String[] args) {
        Executor execute = command -> {
            new Thread(command).start();
        };

        execute.execute(() -> {
            System.out.println("Task executed!");
        });
    }

}
