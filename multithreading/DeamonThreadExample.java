package multithreading;

public class DeamonThreadExample {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                System.out.println("Deamon running....");
            }
        });
        t.setDaemon(true);
        t.start();

        System.out.println("main end here");

    }

}
