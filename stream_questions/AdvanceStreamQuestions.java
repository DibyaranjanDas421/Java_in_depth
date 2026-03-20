
package stream_questions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

public class AdvanceStreamQuestions {

        public static Boolean isPalindrome(String word) {
                return IntStream.range(0, word.length() / 2)
                                .allMatch(i -> word.charAt(i) == word
                                                .charAt(word.length() - 1 - i));
        }

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

                // 47. Generate the Fibonacci Sequence Using Streams

                Stream.iterate(new int[] { 0, 1 }, fib -> new int[] { fib[1], fib[0] + fib[1] })
                                .limit(10)
                                .map(fib -> fib[0])
                                .forEach(System.out::println);
                // 48. Generate a List of Random Numbers Using Streams

                IntStream randomStream = new Random().ints(5);
                randomStream.forEach(System.out::println);
                // 49. Flatten a List of Lists into a Single List
                List<List<Integer>> listOfLists = List.of(
                                List.of(1, 2, 3),
                                List.of(4, 5, 6),
                                List.of(7, 8, 9));
                List<Integer> singleList = listOfLists.stream()
                                .flatMap(x -> x.stream())
                                .toList();
                System.out.println("singleList :" + singleList);
                // 50. Find the Sum of All Even Numbers in a Nested List
                DoubleSummaryStatistics sum = listOfLists.stream()
                                .flatMap(x -> x.stream())
                                .filter(x -> x % 2 == 0)
                                .collect(Collectors.summarizingDouble(x -> x));
                System.out.println(sum.getSum());

                Optional<Integer> sum1 = listOfLists.stream()
                                .flatMap(x -> x.stream())
                                .filter(x -> x % 2 == 0)
                                .reduce((x, y) -> Integer.sum(x, y));
                System.out.println("sum1:" + sum1);
                // 51. Find the Sum of All Odd Numbers in a Nested List
                Integer sumOfOdd = listOfLists.stream()
                                .flatMap(List::stream)
                                .filter(x -> x % 2 != 0)
                                .mapToInt(Integer::intValue)
                                .sum();
                System.out.println("sumOfOdd:" + sumOfOdd);
                // 52. Find the Longest Palindrome in a List of Strings
                List<String> palindromeWord = List.of("madam", "racecar", "apple", "banana", "level");

                Optional<String> longestPalindrome = palindromeWord.stream()
                                .filter(AdvanceStreamQuestions::isPalindrome)
                                .sorted(Comparator.reverseOrder())
                                .findFirst();
                System.out.println("longestPalindrome :" + longestPalindrome);

                String longestPalindrome1 = words.stream()
                                .filter(word -> word.equals(new StringBuilder(word).reverse().toString()))
                                .max(Comparator.comparingInt(String::length))
                                .orElse("");
                System.out.println("Longest Palindrome: " + longestPalindrome);
                // 53. Find the Shortest Palindrome in a List of Strings
                Optional<String> shortestPalindrome = palindromeWord.stream()
                                .filter(AdvanceStreamQuestions::isPalindrome)
                                .sorted()
                                .findFirst();
                System.out.println("shortestPalindrome :" + shortestPalindrome);

                // 54. Find the Longest Word in a String
                String inputs = "hello world this is a test";
                String[] longStrings = inputs.split(" ");
                Optional<String> longestWord = Arrays.stream(longStrings).max(Comparator.comparing(String::length));
                System.out.println("longestWord :" + longestWord);

                // 55. Find the Shortest Word in a String
                Optional<String> shortestWord = Arrays.stream(longStrings).min(Comparator.comparing(String::length));
                System.out.println("shortestWord :" + shortestWord);

                // 56. Find the Number of Words in a String
                List<Integer> countWords = Arrays.stream(longStrings).map(String::length).toList();
                System.out.println("countWords:" + countWords);

                long wordCount = Arrays.stream(input.split(" ")).count();
                System.out.println("Word Count: " + wordCount);
                // 57. Find the Number of Lines in a File

                Path path = Paths.get("D:\\Java_In_depth\\collection\\Test.java");

                try {
                        long lineCount = Files.lines(path).count();
                        System.out.println("line count" + lineCount);
                } catch (IOException e) {
                        e.printStackTrace();
                }
                // 58. Find the Number of Characters in a File
                try {
                        long charCount = Files.lines(path)
                                        .flatMapToInt(String::chars)
                                        .count();
                        System.out.println("charCount :" + charCount);
                } catch (IOException e) {
                        e.printStackTrace();
                }

                // 59. Find the Number of Words in a File
                try {
                        long wordCounts = Files.lines(path)
                                        .flatMap(line -> Arrays.stream(line.split(" ")))
                                        .count();
                        System.out.println("Word Count: " + wordCounts);
                } catch (IOException e) {
                        e.printStackTrace();
                }

                // 60. Find the Number of Unique Words in a File
                try {
                        long uniqueWord = Files.lines(path)
                                        .flatMap(line -> Arrays.stream(line.split(" ")))
                                        .distinct()
                                        .count();
                        System.out.println("uniqueWord: " + uniqueWord);
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

}
