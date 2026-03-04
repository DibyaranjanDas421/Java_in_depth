package collection.list.Linkedlist;

import java.util.Arrays;
import java.util.LinkedList;

public class Linkedlist {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(5);
        list.addFirst(10);
        list.addLast(20);
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list);
        list.remove(list.get(0));
        System.out.println(list);
        list.removeIf(x -> x % 2 == 0);
        System.out.println(list);

        LinkedList<String> animal = new LinkedList<>(Arrays.asList("Cat", "Dog", "Elephent"));
        LinkedList<String> animastoRemove = new LinkedList<>(Arrays.asList("Cat"));

        animal.removeAll(animastoRemove);

        System.out.println(animal);
    }
}
