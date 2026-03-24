package design_pattern.creational_design_pattern.abstract_factory_design_pattern;

public class CarFactory implements VechileFactory {

    @Override
    public Vehicle createVechile() {
        return new Car();
    }

    @Override
    public Engine createEngine() {
        return new CarEngine();
    }

}
