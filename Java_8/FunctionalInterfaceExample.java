package Java_8;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        Lamda l = new Lamda();
        Thread t = new Thread(l);
        t.start();

        Thread t1 = new Thread(() -> System.out.println("Hello!"));

        // SumOperation sumOperation = new SumOperation();
        // System.out.println(sumOperation.operation(10, 20));

        // SubOperation subOperation = new SubOperation();
        // System.out.println(subOperation.operation(10, 20));
        Mathoperation sumOperation = (a, b) -> a + b;

        System.out.println(sumOperation.operation(3, 4));
        Mathoperation subOperation = (a, b) -> b - a;
        System.out.println(subOperation.operation(3, 4));

    }

}

class Lamda implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello!");
    }

}

class SumOperation implements Mathoperation {

    @Override
    public int operation(int a, int b) {
        return a + b;

    }

}

class SubOperation implements Mathoperation {

    @Override
    public int operation(int a, int b) {
        return a - b;

    }

}

interface Mathoperation {
    public int operation(int a, int b);
}
