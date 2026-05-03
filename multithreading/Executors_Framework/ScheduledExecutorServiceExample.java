package multithreading.Executors_Framework;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        scheduledExecutorService.schedule(() -> {

            System.out.println("Runs after 3 sec");

        }, 3, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(() -> {

            System.out.println("Running");

        }, 0, 2, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleWithFixedDelay(() -> {

            System.out.println("Running");

        }, 0, 2, TimeUnit.SECONDS);

        scheduledExecutorService.shutdown();
    }

}
