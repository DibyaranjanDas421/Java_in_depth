package design_pattern.creational_design_pattern.factory_method_design_pattern;

public class CarFactory implements VehicleFactory {

    @Override
    public Vehicle creatVehicle() {
        return new Car();
    }

}
