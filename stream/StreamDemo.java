package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int count = 0;
        for (int i : list) {
            if (i % 2 == 0) {
                count++;
            }
        }

        System.out.println(count);

        System.out.println(list.stream().filter(x -> x % 2 == 0).count());

        // Creating Streams
        // 1- from collection
        List<String> collection = Arrays.asList("A", "B", "C");
        Stream<String> st = collection.stream();
        // 2-From Arrays
        String[] str = { "a", "b", "c" };
        Stream<String> fromArray = Arrays.stream(str);
        // 3-using stream.of
        Stream<String> fromOf = Stream.of("a", "b", "c");
        // 4-infinite Stream
        Stream<Integer> infiniteByGenerate = Stream.generate(() -> 1).limit(100);
        // Stream<Integer> infiniteByGenerate = Stream.generate(() -> 1); if limit is
        // not their then infinite stram will be creating
        Stream<Integer> infiniteStreamByIterate = Stream.iterate(1, x -> x + 1).limit(100);
        // Stream<Integer> infiniteStreamByIterate = Stream.iterate(1, x -> x +
        // 1).limit(100); if limit is not their infinite Stream will created

    }

}
