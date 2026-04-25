package multithreading;

class InterruptDemo implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Inttrepted while sleeping...");
        }
    }
}

public class InterruptExample {

    public static void main(String[] args) throws InterruptedException {
        InterruptDemo i = new InterruptDemo();
        Thread t = new Thread(i);
        t.start();
        Thread.sleep(1000);
        t.interrupt();
    }

}
