package stream;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExample {
    public static void main(String[] args) {
        // 1- collecting to a list
        List<String> list = Arrays.asList("Ankit", "Ankhush", "Anar");
        list.stream()
                .filter(x -> x.startsWith("A"))
                .collect(Collectors.toList());
        // 2- collecting to a set
        List<Integer> list1 = Arrays.asList(1, 2, 3, 3, 4, 5, 5, 7);
        list1.stream()
                .collect(Collectors.toSet());
        // 3-to a specified collection
        ArrayDeque<String> names = list.stream().collect(Collectors.toCollection(() -> new ArrayDeque()));
        // 4-joining
        String concatenated = list.stream().collect(Collectors.joining(", "));
        System.out.println(concatenated);
        // 5-SummarizingData(count,max,avg,sum,min)
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 7, 8, 10, 15);
        IntSummaryStatistics stats = numbers.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println(stats);
        // 6-Avg
        Double avg = numbers.stream().collect(Collectors.averagingInt(x -> x));
        System.out.println("avg:" + avg);
        // 7-counting elements
        System.out.println(numbers.stream().count());
        // 8-Grouping elements
        List<String> words = Arrays.asList("Hello", "World", "Java", "streams", "collecting");
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length)));
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length, Collectors.joining(","))));
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length, Collectors.counting())));
        TreeMap<Integer, Long> map = words.stream()
                .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));
        System.out.println(map);

        // 9-Partitionig by elements
        System.out.println(words.stream().collect(Collectors.partitioningBy(x -> x.length() > 5)));
        // 10-Mapping and counting
        System.out.println(words.stream().collect(Collectors.mapping(String::toUpperCase, Collectors.toList())));
        // Example
        String sentence = "hello world hello java world";
        System.out.println(
                Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(x -> x, Collectors.counting())));

        List<Integer> num = Arrays.asList(1, 2, 3, 4, 6, 7, 8, 10);
        System.out.println(num.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0)));

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("Apple", 10);
        map2.put("Bannana", 20);
        map2.put("Orange", 15);

        Collection<Integer> values = map2.values();
        System.out.println(values.stream().reduce(Integer::sum));

        List<String> fruites = Arrays.asList("Apple", "Banana", "Orange");
        System.out.println(
                fruites.stream().collect(Collectors.groupingBy(String::length, HashMap::new, Collectors.counting())));

        System.out.println(fruites.stream().collect(Collectors.toMap(String::toUpperCase, String::length)));

        List<String> fruite = Arrays.asList("Apple", "Banana", "Orange", "Apple", "Banana");
        System.out.println(fruite.stream().collect(Collectors.toMap(k -> k, v -> 1, (x, y) -> x + y)));

    }
}
