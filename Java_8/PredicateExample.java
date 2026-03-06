package Java_8;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> isEven = x -> x % 2 == 0;

        System.out.println(isEven.test(2));

        Predicate<String> startWithA = x -> x.startsWith("A");
        Predicate<String> endWithA = x -> x.endsWith("A");

        Predicate<String> and = startWithA.and(endWithA);
        System.out.println(and.test("AA"));
    }
}
