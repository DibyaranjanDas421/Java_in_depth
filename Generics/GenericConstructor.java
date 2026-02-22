package Generics;

public class GenericConstructor {

    <U> GenericConstructor(U input) {
        System.out.println(input.getClass().getName());
    }

    <A, B> GenericConstructor(A first, B second) {
        System.out.println("First: " + first + ", Second: " + second);
    }

    <T extends Number> GenericConstructor(T number) {
        System.out.println("Number: " + number);
    }

}
