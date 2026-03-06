package Java_8;

import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<Integer> supplyten = () -> 10;

        System.out.println(supplyten.get());

        Supplier<String> givenHelloWorld = () -> "HelloWorld";

        System.out.println(givenHelloWorld.get());
    }
}
