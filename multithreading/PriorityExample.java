package multithreading;

public class PriorityExample {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("LOW");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("HIGH");
        });

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
    }

}
