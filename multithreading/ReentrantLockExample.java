package multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    public static void main(String[] args) throws InterruptedException {
        BankAccount acc = new BankAccount();

        Thread t1 = new Thread(() -> {
            acc.withdraw(50);
        });

        Thread t2 = new Thread(() -> {
            acc.withdraw(50);
        });

        // t1.start();
        // t2.start();

        Thread t3 = new Thread(() -> {
            try {
                acc.withdrawWithWait(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t4 = new Thread(() -> {
            try {
                acc.withdrawWithWait(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t3.start();
        t4.start();

        Thread t5 = new Thread(() -> {
            acc.longRunningTask();
        }, "T1");

        Thread t6 = new Thread(() -> {
            acc.withdrawInterruptibly(100);
        }, "T2");

        t5.start();
        Thread.sleep(500); // ensure T1 gets lock first

        t6.start();

        Thread.sleep(2000); // let T2 wait for lock
        System.out.println("Main thread interrupting T2...");

        t6.interrupt();

    }
}

class BankAccount {
    private Integer balance = 1000;

    private final ReentrantLock lock = new ReentrantLock();

    public void withdraw(Integer amount) {
        lock.tryLock();

        try {
            balance -= amount;
            System.out.println("Balance :" + balance);
        } finally {
            lock.unlock();
        }
    }

    public void withdrawWithWait(Integer amount) throws InterruptedException {
        if (lock.tryLock(1, TimeUnit.SECONDS)) {
            try {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() +
                        " Balance: " + balance);
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Timeout! Could not acquire lock");
        }
    }

    public void longRunningTask() {
        lock.lock();

        try {
            System.out.println(Thread.currentThread().getName() + " acquired lock");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " released lock");
        }
    }

    public void withdrawInterruptibly(Integer amount) {

        try {
            System.out.println(Thread.currentThread().getName() + " trying to acquire lock...");

            lock.lockInterruptibly();
            try {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() +
                        " withdrew money. Balance: " + balance);
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }
            }

        } catch (

        InterruptedException e) {
            System.out.println(Thread.currentThread().getName() +
                    " was interrupted while waiting for lock");
        }

    }
}