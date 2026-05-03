package multithreading;

public class DeadLockExample {

    public static void main(String[] args) {
        Pen pen = new Pen();
        Paper paper = new Paper();

        Thread t1 = new Thread(() -> {
            pen.writeWithPen(paper);
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            paper.writeWithPaper(pen);
        }, "Thread-2");

        // t1.start();
        // t2.start();

        Task task = new Task(pen, paper);

        Thread t3 = new Thread(task::write, "Thread-1");
        Thread t4 = new Thread(task::write, "Thread-2");

        t3.start();
        t4.start();
    }
}

class Pen {

    public synchronized void writeWithPen(Paper papper) {
        System.out.println(Thread.currentThread().getName()
                + " holding PEN, waiting for PAPER");
        papper.finishWriting();
    }

    public synchronized void finishWriting() {
        System.out.println("Finished writing with PEN");
    }
}

class Paper {
    public synchronized void writeWithPaper(Pen pen) {
        System.out.println(Thread.currentThread().getName()
                + " holding PEN, waiting for PAPER");

        pen.finishWriting();
    }

    public synchronized void finishWriting() {
        System.out.println("Finished writing with PEN");
    }
}

class Task {
    private Pen pen;
    private Paper paper;

    public Task(Pen pen, Paper paper) {
        this.paper = paper;
        this.pen = pen;
    }

    public void write() {
        synchronized (pen) {
            System.out.println(Thread.currentThread().getName()
                    + " locked PEN");
            synchronized (paper) {
                System.out.println(Thread.currentThread().getName()
                        + " locked PAPER");
                System.out.println("Writing safely...");
            }
        }
    }
}