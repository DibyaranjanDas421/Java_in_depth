package collection.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class LinkedListAsQueue {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // queue.remove(); throws exception if no element is their to remove
        System.out.println(queue.poll()); // returns null is no element is their to remove
        // queue.element(); throws exception if no element is in head
        System.out.println(queue.peek()); // retuns null is no elment is their in peek
        queue.add(1);
        queue.add(3);
        queue.add(8);
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);

        Queue<Integer> queue2 = new ArrayBlockingQueue<>(2);
        queue2.add(7);
        queue2.add(9);
        // queue2.add(6); throws exceptio if no spce is their to add
        System.out.println(queue2.offer(6)); // returns true or false if element is added or not

    }

}
