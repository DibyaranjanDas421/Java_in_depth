package design_pattern.creational_design_pattern.factory_method_design_pattern;

public class Main {
    public static void main(String[] args) {
        VehicleFactory vf = new CarFactory();
        Vehicle vehicle = vf.creatVehicle();
        vehicle.drive();
    }

}
