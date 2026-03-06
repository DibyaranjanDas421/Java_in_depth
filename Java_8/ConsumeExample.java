package Java_8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumeExample {
    public static void main(String[] args) {
        Consumer<Integer> print = x -> System.out.println(x);
        print.accept(10);

        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        Consumer<List<Integer>> printList = (x) -> {
            System.out.print("[");
            for (int i : x) {
                System.out.print(i + ",");
            }
            System.out.print("]");
        };

        printList.accept(list);
    }

}
