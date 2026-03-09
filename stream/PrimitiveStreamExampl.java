package stream;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class PrimitiveStreamExampl {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };

        IntStream ps = Arrays.stream(arr);
        System.out.println(IntStream.range(1, 5).boxed().collect(Collectors.toList()));
        System.out.println(IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList()));
        IntStream.of(1, 2, 3);

        DoubleStream doubles = new Random().doubles(5);
        // sum,min,max,average,summarySratics
        System.out.println("summaryStatistics:" + doubles.summaryStatistics());
        doubles.mapToInt(x -> (int) x + 1);
        System.out.println(doubles);

        IntStream integers = new Random().ints(5);
        System.out.println(integers);
    }

}
