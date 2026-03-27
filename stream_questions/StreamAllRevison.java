package stream_questions;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamAllRevison {
        public static void main(String[] args) {
                // 1. Find the Sum of All Elements in a List

                List<Integer> numbers = List.of(1, 2, 3, 4, 5);

                Optional<Integer> sum = numbers.stream()
                                .reduce((x, y) -> x + y);
                System.out.println("sum :" + sum);

                // 2. Find the Product of All Elements in a List
                Integer product = (numbers.stream()
                                .reduce(1, (a, b) -> a * b));
                System.out.println("product :" + product);

                // 3. Find the Average of All Elements in a List
                Double avg = numbers.stream()
                                .collect(Collectors.averagingDouble(x -> x));
                System.out.println("avg:" + avg);

                // 4. Find the Maximum Element in a List
                Integer max = numbers.stream()
                                .sorted(Comparator.reverseOrder())
                                .findFirst().orElse(null);
                System.out.println("max:" + max);

                // 5-Find the Minimum Element in a List
                Integer min = numbers.stream()
                                .min(Integer::compare).orElse(0);
                System.out.println("min :" + min);

                // 6. Count the Number of Elements in a List
                Long count = numbers.stream()
                                .count();
                System.out.println("count :" + count);

                // 8.Find the Sum of All Elements in a List

                List<Integer> nums = List.of(1, 2, 3, 4, 5);
                Integer sum1 = nums.stream()
                                .reduce(0, (a, b) -> a + b);
                System.out.println("sum :" + sum1);

                // Find the Most Frequent Element in a List
                List<String> words = List.of("apple", "banana", "apple", "orange", "banana", "apple");

                String frequent = words.stream()
                                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                                .entrySet().stream()
                                .max(Map.Entry.comparingByValue())
                                .map(x -> x.getKey())
                                .orElse(null);
                System.out.println("requent :" + frequent);

                // Find the Product of All Elements in a List
                Integer products = numbers.stream()
                                .reduce(1, (x, y) -> x * y);
                System.out.println("products :" + products);

                // Find the Sum of Digits of a Number
                int number = 12345;
                Integer sumofdigits = String.valueOf(number)
                                .chars()
                                .map(Character::getNumericValue)
                                .sum();
                System.out.println("sumofdigits :" + sumofdigits);

                // Find the Least Frequent Element in a List

                String leastFrequequent = words.stream()
                                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                                .entrySet()
                                .stream()
                                .min(Map.Entry.comparingByValue())
                                .map(x -> x.getKey())
                                .orElse(null);
                System.out.println("leastFrequequent :" + leastFrequequent);

        }

}
