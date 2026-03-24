package polymorphism.upcastingAndDownCasting;

public class Dog implements Animal {

    @Override
    public void sayHello() {
        System.out.println("Hello from dog !");
    }

}
