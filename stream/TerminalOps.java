package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TerminalOps {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 10);

        // 1-collect
        System.out.println(list.stream().skip(1).collect(Collectors.toList()));
        // 2-forEach
        list.stream()
                .forEach(System.out::println);

        // 3-reduce
        Optional<Integer> opt = list.stream()
                .reduce(Integer::sum);
        System.out.println(opt.get());
        // 4-count
        System.out.println(list.stream().count());
        // 5-anyMatch,allMatch,noneMatch
        System.out.println(list.stream().anyMatch(x -> x % 2 == 0));
        System.out.println(list.stream().allMatch(x -> x > 0));
        System.out.println(list.stream().noneMatch(x -> x < 0));
        // 6-findFirst FindAny

        System.out.println(list.stream().findFirst().get());
        System.out.println(list.stream().findAny().get());

        // Example
        System.out.println(list.stream().map(x -> x * x).collect(Collectors.toList()));
        // occurens of a character
        String occr = "Hello World";
        System.out.println(occr.chars().filter(x -> x == 'l').count());

    }
}
