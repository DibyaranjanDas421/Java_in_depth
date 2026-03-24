package design_pattern.creational_design_pattern.abstract_factory_design_pattern;

public class Main {
    public static void main(String[] args) {
        VechileFactory v = new CarFactory();
        Vehicle c = v.createVechile();
        Engine e = v.createEngine();

        c.drive();
        e.start();
    }

}
