package polymorphism.upcastingAndDownCasting;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Animal> list = new ArrayList<>();
        list.add(new Dog());
        list.add(new Cat());

        for (Animal a : list) {
            System.out.println(a);
        }

        Animal c = new Cat();

        Dog d = (Dog) c; // class Cast Exception

        if (c instanceof Dog) {
            Dog d1 = (Dog) c;
        }
    }
}
