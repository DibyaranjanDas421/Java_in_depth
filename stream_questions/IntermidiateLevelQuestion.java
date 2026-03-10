package stream_questions;

import java.lang.StackWalker.Option;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntermidiateLevelQuestion {
    public static void main(String[] args) {
        // 21. Find the Sum of Digits of a Number

        int number = 12345;
        int sum = String.valueOf(number)
                .chars().map(Character::getNumericValue)
                .sum();
        System.out.println("sum :" + sum);

        // 22. Find the Factorial of a Number
        int num = 10;
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) { // by my logic
            nums[i] = i + 1;
        }
        Integer fac = Arrays.stream(nums).boxed().reduce(1, (a, b) -> a * b);
        System.out.println("Factorial :" + fac);

        int factorial = IntStream.rangeClosed(1, number)
                .reduce(1, (a, b) -> a * b);
        System.out.println("Factorial: " + factorial);

        // 23. Find the Second-Largest Element in a List
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        Integer secondMax = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(0);
        System.out.println(secondMax);

        // 24. Find the Second-Smallest Element in a List
        Integer secondSmall = numbers.stream()
                .sorted(Comparator.naturalOrder())
                .skip(1)
                .findFirst()
                .orElse(0);
        System.out.println(secondSmall);

        // 25. Find the Longest String in a List
        List<String> words = List.of("apple", "banana", "kiwi");

        Optional<String> maxLengthWord = words.stream()
                .sorted((o1, o2) -> o2.length() - o1.length())
                .findFirst();
        System.out.println(maxLengthWord.get());

        String longest = words.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println("Longest Word: " + longest);

        // 26. Find the Shortest String in a List
        String shortest = words.stream()
                .max(Comparator.comparingInt(String::length).reversed())
                .orElse("");
        System.out.println("Longest Word: " + shortest);
    }
}
