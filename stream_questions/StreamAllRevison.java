package stream_questions;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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

    }

}
