import java.util.List;

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
        System.out.println("median :" + median);

    }

}
