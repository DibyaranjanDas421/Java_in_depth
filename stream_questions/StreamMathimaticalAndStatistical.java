import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Map;

public class StreamMathimaticalAndStatistical {

        public static void main(String[] args) {
                // 81. Find the Standard Deviation of a List of Numbers
                List<Double> numbers = List.of(1.0, 2.0, 3.0, 4.0, 5.0);

                double mean = numbers.stream()
                                .mapToDouble(Double::doubleValue).average().orElse(0);

                double variance = numbers.stream()
                                .mapToDouble(n -> Math.pow(n - mean, 2))
                                .average().orElse(0);
                double stdDev = Math.sqrt(variance);
                // System.out.println("Standard Deviation: " + stdDev);

                // 82. Find the Median of a List of Numbers

                List<Integer> nums = List.of(1, 2, 3, 4, 5);

                Double median = nums.stream()
                                .sorted()
                                .skip((nums.size() - 1) / 2)
                                .limit(2 - nums.size() % 2)
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(0);
                // System.out.println("median :" + median);

                List<Integer> number = List.of(1, 2, 2, 3, 4, 4, 4);
                // 83. Find the Mode of a List of Numbers

                Integer mode = number.stream()
                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                                .entrySet()
                                .stream()
                                .max(Map.Entry.comparingByValue())
                                .map(Map.Entry::getKey)
                                .orElse(0);
                // System.out.println("mode : " + mode);

                // 84. Find the Sum of Squares of All Elements in a List

                List<Integer> num = List.of(1, 2, 3, 4, 5);
                Integer sum = num.stream()
                                .map(x -> x * x)
                                .reduce((x, y) -> x + y)
                                .orElse(0);
                // System.out.println("sum :" + sum);

                // 85. Find the Sum of Cubes of All Elements in a List
                Integer cube = num.stream()
                                .map(x -> x * x * x)
                                .reduce((x, y) -> x + y)
                                .orElse(0);
                // System.out.println("cube :" + cube);

                // 86. Find the Sum of All Prime Numbers in a List

                List<Integer> primeList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

                Integer primeSum = primeList.stream()
                                .filter(x -> isPrime(x))
                                .reduce((x, y) -> x + y)
                                .orElse(0);
                // System.out.println("primeSum :" + primeSum);

                int sumOfPrimes = primeList.stream()
                                .filter(n -> n > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(n))
                                                .noneMatch(i -> n % i == 0))
                                .mapToInt(Integer::intValue)
                                .sum();
                // System.out.println("Sum of Primes: " + sumOfPrimes);

                // 87. Find the Sum of All Fibonacci Numbers in a List
                List<Integer> numss = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

                Integer fibonacciSum = numss.stream()
                                .filter(n -> {

                                        int a = 0, b = 1;
                                        while (b < n) {
                                                int temp = b;
                                                b = a + b;
                                                a = temp;
                                        }

                                        return b == n;
                                })
                                .mapToInt(Integer::intValue)
                                .sum();
                System.out.println("fibonacciSum :" + fibonacciSum);

                // 88. Find the Sum of All Even-Indexed Elements in a List

                int sumOfEvenIndex = IntStream.rangeClosed(0, numss.size() - 1)
                                .filter(x -> x % 2 == 0)
                                .map(numss::get)
                                .sum();

                System.out.println("sumOfEvenIndex :" + sumOfEvenIndex);

                // 89. Find the Sum of All Odd-Indexed Elements in a List
                int sumOfOddIndex = IntStream.range(0, numss.size())
                                .filter(x -> !(x % 2 == 0))
                                .map(numss::get)
                                .sum();
                System.out.println("sumOfOddIndex :" + sumOfOddIndex);

                // 90. Find the Sum of All Elements Greater Than a Specific Value
                int threshold = 5;

                int sumAboveThreshold = numss.stream()
                                .filter(n -> n > threshold)
                                .mapToInt(Integer::intValue)
                                .sum();

                System.out.println("sumAboveThreshold :" + sumAboveThreshold);
                // 91. Process a Large List of Numbers in Parallel
                List<Integer> largeNumbers = IntStream.rangeClosed(1, 100000).boxed().collect(Collectors.toList());

                Long sumOfLargeNumber = largeNumbers.parallelStream()
                                .mapToLong(Integer::intValue)
                                .sum();
                System.out.println("sumOfLargeNumber :" + sumOfLargeNumber);

                // 92. Find the Sum of All Elements in a List Using Parallel Streams

                List<Integer> elements = List.of(1, 2, 3, 4, 5);

                Integer sumOfAllElements = elements
                                .stream()
                                .mapToInt(Integer::intValue)
                                .sum();
                System.out.println("sumOfAllElements :" + sumOfAllElements);

                // 93. Find the Maximum Element in a List Using Parallel Streams

                Integer maxNumber = elements
                                .parallelStream()
                                .sorted(Comparator.reverseOrder())
                                .findFirst()
                                .orElse(null);
                System.out.println("maxNumber :" + maxNumber);

                Integer maxNumber1 = elements
                                .parallelStream()
                                .max(Integer::compare)
                                .orElse(null);
                System.out.println("maxNumber :" + maxNumber1);

                // 94. Find the Minimum Element in a List Using Parallel Streams

                Integer minNumber = elements
                                .parallelStream()
                                .min(Integer::min)
                                .orElse(null);
                System.out.println("minNUmber :" + minNumber);

                // 95. Sort a List of Integers in Parallel Using Parallel Streams
                List<Integer> sortedElements = elements
                                .parallelStream()
                                .sorted(Comparator.reverseOrder())
                                .collect(Collectors.toList());
                System.out.println("sorted elements :" + sortedElements);

                // 96. Filter a List of Strings in Parallel Using Parallel Streams
                List<String> words = List.of("apple", "banana", "kiwi", "mango");

                List<String> filtered = words
                                .parallelStream()
                                .filter(w -> w.length() > 4)
                                .collect(Collectors.toList());
                System.out.println("filtered :" + filtered);

                // 97. Count the Occurrences of Each Element in a List Using Parallel Streams
                List<String> words1 = List.of("apple", "banana", "apple", "orange");

                Map<String, Long> occurences = words1
                                .parallelStream()
                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                System.out.println("occurences :" + occurences);

                // 99. Merge Two Lists in Parallel Using Parallel Streams
                List<Integer> list1 = List.of(1, 2, 3);
                List<Integer> list2 = List.of(4, 5, 6);

                List<Integer> merged = Stream.concat(list1.parallelStream(), list2.parallelStream())
                                .collect(Collectors.toList());
                System.out.println("merged :" + merged);

                // 100. Find the Intersection of Two Lists Using Parallel Streams

                List<Integer> interSection = list1
                                .parallelStream()
                                .filter(list2::contains)
                                .collect(Collectors.toList());
                System.out.println("Intersection :" + interSection);

        }

        public static boolean isPrime(int num) {

                if (num <= 1) {
                        return false;
                }

                for (int i = 2; i <= Math.sqrt(num); i++) {

                        if (num % i == 0) {
                                return false;
                        }
                }

                return true;
        }

}
