package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LazyEvalutionExample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bod", "charlie", "Baap");

        Stream<String> str = names.stream()
                .filter(name -> {
                    System.out.println("Filtering:" + name);
                    return name.length() > 3;
                });
        System.out.println("Before Terminal");
        List<String> res = str.collect(Collectors.toList());
        System.out.println("After terminal Operation");
        System.out.println(res);
    }
}
