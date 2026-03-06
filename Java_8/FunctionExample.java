package Java_8;

import java.util.function.Function;

public class FunctionExample {

    public static void main(String[] args) {
        Function<Integer, Integer> half = x -> x / 2;
        System.out.println(half.apply(10));

        // chaining
        Function<Integer, Integer> doubled = n -> n * 2;

        Function<Integer, Integer> triplet = n -> n * 3;

        System.out.println(doubled.andThen(triplet).apply(20));
        System.out.println(doubled.compose(triplet).apply(20));
        System.out.println(triplet.compose(doubled).apply(20));

        Function<Integer, Integer> identity = Function.identity();
        System.out.println(identity.apply(15));

    }

}
