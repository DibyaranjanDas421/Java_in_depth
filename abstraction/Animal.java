package abstraction;

abstract class Animal {

    public Integer age;

    protected Animal() {
        System.out.println("Animal called!");
        age = 20;
    }

    abstract void makeSound();

}
