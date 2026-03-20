package Inheritance;

public class CompositionExample {
    public static void main(String[] args) {
        Car c = new Car(new PetrolEngine());
        Car c1 = new Car(new PetrolEngine());

    }
}

interface Engine {
    void start();
}

class PetrolEngine implements Engine {

    @Override
    public void start() {
        System.out.println("Petrol Engine");
    }

}

class ElectricEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Electric Engine");
    }
}

class Car {
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    void start() {
        engine.start();
    }
}
