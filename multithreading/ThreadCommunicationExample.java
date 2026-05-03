package multithreading;

public class ThreadCommunicationExample {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        Thread producer = new Thread(() -> {

            try {
                for (int i = 0; i < 5; i++) {
                    sharedResource.produce(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        Thread consumer = new Thread(() -> {

            try {
                for (int i = 0; i < 5; i++) {
                    sharedResource.consume();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        producer.start();
        consumer.start();
    }

}

class SharedResource {

    private Integer data = 0;
    private Boolean hasData = false;

    public synchronized void produce(Integer value) throws InterruptedException {
        while (hasData) {
            wait();
        }

        data = value;
        hasData = true;
        System.out.println("Produced: " + data);
        notify();
    }

    public synchronized Integer consume() throws InterruptedException {
        while (!hasData) {
            wait();
        }

        hasData = false;
        System.out.println("Consumed: " + data);
        notify();

        return data;
    }

}
