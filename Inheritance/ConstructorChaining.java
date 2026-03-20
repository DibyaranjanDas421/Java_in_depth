package Inheritance;

public class ConstructorChaining {
    public static void main(String[] args) {
        Dog g = new Dog();
    }
}

class Mamal {
    public Mamal() {
        System.out.println("Mamal callled---------");
    }
}

class Animal extends Mamal {
    public Animal() {
        System.out.println("Animal callled---------");

    }
}

class Dog extends Animal {
    public Dog() {
        System.out.println("Dog called-------------");
    }
}
