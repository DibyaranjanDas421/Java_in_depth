import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
                System.out.println("primeSum :" + primeSum);

                int sumOfPrimes = primeList.stream()
                                .filter(n -> n > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(n))
                                                .noneMatch(i -> n % i == 0))
                                .mapToInt(Integer::intValue)
                                .sum();
                System.out.println("Sum of Primes: " + sumOfPrimes);

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
