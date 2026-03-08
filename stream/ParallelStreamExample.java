package stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParallelStreamExample {

    public static void main(String[] args) {
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(10000).toList();
        long startTime = System.currentTimeMillis();
        List<Long> fac = list.stream().map(ParallelStreamExample::factorial).toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Time take by normal stream: " + (endTime - startTime) + ": ms");

        startTime = System.currentTimeMillis();
        List<Long> fac1 = list.parallelStream().map(ParallelStreamExample::factorial).sequential().toList();
        endTime = System.currentTimeMillis();
        System.out.println("Time take by paralle stream: " + (endTime - startTime) + ": ms");

        // cumulative sum
        // [1,2,3,4,5]-->[1,3,6,10,15]

        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5);
        AtomicInteger res = new AtomicInteger(0);
        List<Integer> result = list3.parallelStream()
                .map((x -> res.addAndGet(x))).toList();

        System.out.println("Expected: [1,3,6,10,15]");
        System.out.println("Actual result: " + result);

    }

    private static Long factorial(int num) {
        long res = 1;
        for (int i = 0; i <= num; i++) {
            res *= i;
        }
        return res;
    }

}
