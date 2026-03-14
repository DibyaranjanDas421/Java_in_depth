
package stream_questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Map;

public class AdvanceStreamQuestions {

    public static void main(String[] args) {
        // 41. Find the Most Frequent Element in a List
        List<String> words = List.of("apple", "banana", "apple", "orange", "banana", "apple");

        String mostFrequent = words.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        System.out.println("mostFrequent:" + mostFrequent);

        // 42. Find the Least Frequent Element in a List

        String leastFrequent = words.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        System.out.println("leastFrequent:" + leastFrequent);

        // 43. Duplicate Charecters in a String
        String inpuString = "I Love Java";
        String[] s1 = inpuString.split(" ");
        String s2 = String.join("", s1);
        s2.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 2)
                .forEach(System.out::println);

    }

}
