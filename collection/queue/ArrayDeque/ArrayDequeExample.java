package collection.queue.ArrayDeque;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeExample {

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerFirst(5);
        deque.offerFirst(10);
        deque.offerLast(15);
        deque.offerFirst(20);

        deque.removeFirst();
        deque.pollLast();

        System.out.println(deque);
    }

}
