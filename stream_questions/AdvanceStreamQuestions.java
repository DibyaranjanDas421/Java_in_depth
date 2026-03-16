
package stream_questions;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Map;
import java.util.Optional;

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

                String input = "hello";
                Optional<Map.Entry<Character, Long>> nonRepeat = input.chars()
                                .mapToObj(c -> (char) c)
                                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                                .entrySet()
                                .stream()
                                .filter(entry -> entry.getValue() == 1)
                                .findFirst();
                System.out.println("nonRepeat:" + nonRepeat.get());
                // 44. Find the First Repeated Character in a String
                Optional<Map.Entry<Character, Long>> Repeated = input.chars()
                                .mapToObj(c -> (char) c)
                                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                                .entrySet()
                                .stream()
                                .filter(entry -> entry.getValue() > 1)
                                .findFirst();
                System.out.println("Repeated:" + Repeated.get());

                // 45. Check if a String is a Palindrome
                String inputPalindrome = "madam";
                Boolean isPalindrome = IntStream.range(0, inputPalindrome.length() / 2)
                                .allMatch(i -> inputPalindrome.charAt(i) == inputPalindrome
                                                .charAt(inputPalindrome.length() - 1 - i));
                System.out.println("isPalindrome:" + isPalindrome);
                // 46. Find All Anagrams of a String from a List
                List<String> wordsAnagrams = List.of("listen", "silent", "enlist", "google", "inlets");
                String target = "silent";

                List<String> anagrams = wordsAnagrams.stream()
                                .filter(word -> Arrays.equals(
                                                word.chars().sorted().toArray(), target.chars().sorted().toArray()))
                                .collect(Collectors.toList());
                System.out.println("anagrams :" + anagrams);

        }

}
