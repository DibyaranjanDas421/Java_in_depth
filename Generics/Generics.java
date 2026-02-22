package Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generics {

    public static void main(String[] args) {

        ArrayList list = new ArrayList<>();

        list.add("hello");
        list.add(1);
        list.add(2);

        // String str = (String) list.get(0);
        // String str1 = (String) list.get(1);

        GenericsClass<Integer> gen = new GenericsClass<>();
        gen.setValue(10);
        System.out.println(gen.getValue());

        TwoParameterGenericsClass<String, Integer> tp = new TwoParameterGenericsClass<>("score", 100);
        System.out.println(tp.getKey());
        System.out.println(tp.getValue());

        GenericInterfaceImpl<String> geni = new GenericInterfaceImpl<>();
        geni.add("Dibya");
        System.out.println(geni.get());

        PairImpl<String, Integer> pi = new PairImpl<>("AIR", 101);

        System.out.println(pi.getKey());
        System.out.println(pi.getValue());

        double result1 = Operation.ADD.apply(10, 20);

        System.out.println(result1);

        int result3 = ArithmeticOperation.ADD.calculate(10, 5);
        int result4 = ArithmeticOperation.SUBTRACT.calculate(10, 5);
        System.out.println(result3); // Output: 15
        System.out.println(result4);

        GenericConstructor gencon = new GenericConstructor(12.5);
        new GenericConstructor(10, "Ten");
        new GenericConstructor(3.14, 42);
        new GenericConstructor(3.14);

        MyNumber myNumber = new MyNumber(12);
        Boxx<MyNumber> box = new Boxx<>(myNumber);
        box.display();

        WildCardsInGenerics WildCardsInGenerics = new WildCardsInGenerics();

        List<String> stringList = Arrays.asList("Apple", "Banana", "Orange");
        List<Integer> integerList = Arrays.asList(1, 2, 3);

        WildCardsInGenerics.printList(stringList); // Works
        WildCardsInGenerics.printList(integerList);
    }
}