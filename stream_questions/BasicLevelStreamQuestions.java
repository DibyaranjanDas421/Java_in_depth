

import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BasicLevelStreamQuestions {

    public static void main(String[] args) {
        // 1. Find the Sum of All Elements in a List

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Double sum = numbers.stream()
                .collect(Collectors.summingDouble(x -> x));
        System.out.println("sum :" + sum);

        int sum1 = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum: " + sum1);

        // 2. Find the Product of All Elements in a List
        Integer product = numbers.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println("product :" + product);

        // 3. Find the Average of All Elements in a List
        Double avg = numbers.stream()
                .collect(Collectors.averagingDouble(x -> x));
        System.out.println("average :" + avg);

        Double avg1 = numbers.stream()
                .mapToDouble(Integer::intValue).average().orElse(0);
        System.out.println("average :" + avg1);

        // 4. Find the Maximum Element in a List
        Optional<Integer> max = numbers.stream()
                .collect(Collectors.maxBy(Comparator.naturalOrder()));
        System.out.println("Max :" + max.get());
        int max1 = numbers.stream().max(Integer::compare).orElse(0);
        System.out.println("Max1: " + max1);

        // 5. Find the Minimum Element in a List
        Optional<Integer> min = numbers.stream()
                .collect(Collectors.minBy(Comparator.naturalOrder()));
        System.out.println("Min :" + min.get());

        int min1 = numbers.stream().min(Integer::compare).orElse(0);
        System.out.println("Min1: " + min1);

        // 6. Count the Number of Elements in a List

        Long count = numbers.stream()
                .count();
        System.out.println("count:" + count);

        // 7. Check if a List Contains a Specific Element

        Boolean present = numbers.stream()
                .anyMatch(x -> x == 3);
        System.out.println("present:" + present);

        // 8. Filter Out Even Numbers from a List

        List<Integer> even = numbers.stream()
                .filter(x -> x % 2 == 0).toList();
        System.out.println("even :" + even);
        // 9. Filter Out Odd Numbers from a List

        List<Integer> odd = numbers.stream()
                .filter(x -> x % 2 != 0).toList();
        System.out.println("odd :" + odd);

        // 10. Convert a List of Strings to Uppercase

        List<String> words = List.of("hello", "world");

        List<String> upper = words.stream()
                .map(String::toUpperCase).toList();
        System.out.println("upperCase :" + upper);

        // 11. Convert a List of Integers to Their Squares

        List<Integer> square = numbers.stream()
                .map(x -> x * x).toList();
        System.err.println("square :" + square);

        // 12. Find the First Element in a List

        Optional<Integer> first = numbers.stream()
                .findFirst();
        System.out.println("first :" + first);

        // 13. Find the Last Element in a List
        Optional<Integer> last = numbers.stream()
                .reduce((a, b) -> b);
        System.out.println("last :" + last.get());

        // 14. Check if All Elements in a List Satisfy a Condition

        Boolean cond = numbers.stream()
                .allMatch(x -> x > 0);
        System.out.println("condition :" + cond);

        // 15. Check if Any Element in a List Satisfies a Condition

        Boolean anycond = numbers.stream()
                .anyMatch(x -> x % 2 == 0);
        System.out.println("AnyMaptch :" + anycond);

        // 16. Remove Duplicate Elements from a List
        List<Integer> number = List.of(1, 2, 3, 4, 5, 5, 3, 4);

        List<Integer> ditinct = number.stream().distinct().toList();
        System.out.println("after removeing duplicate: " + ditinct);

        // 17. Sort a List of Integers in Ascending Order

        List<Integer> nums = List.of(5, 3, 1, 4, 2);

        List<Integer> ascsort = nums.stream()
                .sorted().toList();
        System.out.println("ascsort :" + ascsort);

        // 18. Sort a List of Integers in Descending Order
        List<Integer> descsort = nums.stream()
                .sorted(Comparator.reverseOrder()).toList();
        System.out.println("descsort :" + descsort);

        // 19. Sort a List of Strings in Alphabetical Order
        List<String> word = List.of("banana", "apple", "cherry");

        List<String> alphaString = word.stream()
                .sorted().toList();
        System.out.println("AlphabeticalOrder Sorting: " + alphaString);

        // 20. Sort a List of Strings by Their Length

        List<String> lengthString = word.stream()
                .sorted((o1, o2) -> o2.length() - o1.length()).toList();
        System.out.println("Lenght Order Sorting: " + lengthString);

        List<String> words1 = List.of("apple", "banana", "kiwi");
        List<String> sortedWords = words1.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println("Sorted Words by Length: " + sortedWords);
    }

}
