package Java_8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class IterableExample {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(6);
        list.add(9);
        list.add(11);
        list.add(20);
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        List<Integer> list1 = new CopyOnWriteArrayList<>();
        list1.add(10);
        list1.add(15);
        list1.add(12);

        Iterator<Integer> itr1 = list1.iterator();
        while (itr1.hasNext()) {
            Integer num = itr1.next();

            if (num % 2 == 0) {
                list1.remove(num);
            }
        }
    }
}
