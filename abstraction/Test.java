package abstraction;

public class Test {

    public static void main(String[] args) {
        Animal d = new Dog();
        d.makeSound();
        System.out.println(d.age);
    }

}
