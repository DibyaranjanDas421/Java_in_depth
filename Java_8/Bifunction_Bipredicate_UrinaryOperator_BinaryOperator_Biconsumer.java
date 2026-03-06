package Java_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Bifunction_Bipredicate_UrinaryOperator_BinaryOperator_Biconsumer {
    public static void main(String[] args) {
        // Bifunction
        BiFunction<Integer, Integer, Integer> half = (x, y) -> (x * y) / 2;
        BiPredicate<Integer, Integer> isEven = (x, y) -> (x + y) % 2 == 0;
        BiConsumer<Integer, Integer> print = (x, y) -> {
            System.out.print(x);
            System.out.println(y);
        };

        UnaryOperator<Integer> doubled = (x) -> x * 2;

        BinaryOperator<Integer> sum = (x, y) -> x + y;

        // method reference

        Consumer<Integer> printelement = System.out::println;

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        nums.stream()
                .forEach(System.out::print);

        List<String> moblelist = Arrays.asList("A", "B", "C");

        List<MobilePhone> mobilePhones = moblelist.stream().map(MobilePhone::new).collect(Collectors.toList());

    }
}

class MobilePhone {
    String name;

    public MobilePhone(String name) {
        this.name = name;
    }
}
