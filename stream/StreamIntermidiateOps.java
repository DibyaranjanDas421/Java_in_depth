package stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIntermidiateOps {

    public static void main(String[] args) {

        // 1-filter
        List<String> list = Arrays.asList("Aknit", "Dibya", "Debu", "Ankit");
        System.out.println(list.stream().filter(x -> x.startsWith("A")).count());
        // 2-map
        System.out.println(list.stream().map(String::toUpperCase).collect(Collectors.toList()));
        // 3-sorted
        System.out.println(list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()));
        System.out.println(list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
        System.out.println(list.stream().sorted((o1, o2) -> o1.length() - o2.length()).collect(Collectors.toList()));

        // 4-distinct
        System.out.println(list.stream().filter(x -> x.startsWith("A")).distinct().collect(Collectors.toList()));

        // 5-limit
        System.out.println(Stream.iterate(1, x -> x + 1).limit(20).toList());
        // 6-skip
        System.out.println(Stream.iterate(1, x -> x + 1).skip(10).limit(30).toList());
        // 7-peek
        Stream.iterate(1, x -> x + 1).limit(10).peek(System.out::println).count();
        // 9- toArray
        Object[] array = Stream.of(1, 2, 3, 4).toArray();
        // 10-min max
        System.out.println(Stream.of(1, 2, 4, 5, 6).min(Comparator.naturalOrder()));
        System.out.println(Stream.of(4, 6, 7, 8, 9).max(Comparator.naturalOrder()));
        // 11-flatMap
        List<List<String>> listofListOfString = Arrays.asList(

                Arrays.asList("Ankit", "dibya"),
                Arrays.asList("CSE", "EE"),
                Arrays.asList("EEE", "IT"));

        System.out.println(listofListOfString.stream().flatMap(x -> x.stream()).map(String::toUpperCase).toList());

        List<String> setence = Arrays.asList(

                "Hello  World",
                "Hello java");

        System.out.println(setence.stream().flatMap(x -> Arrays.stream(x.split(" ")))
                .map(String::toUpperCase).toList());

        // 12- forEach Order

        List<Integer> list4 = Arrays.asList(1, 2, 23, 34, 45);
        list4.parallelStream().forEach(System.out::println);

        list4.parallelStream().forEachOrdered(System.out::println);
    }

}
