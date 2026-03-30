package design_pattern.creational_design_pattern.prototype_design_pattern.deep_copy;

public class Main {
    public static void main(String[] args) throws Exception {
        Employee e1 = new Employee(1, "Dibya", new Address("Mumbai"));

        Employee e2 = (Employee) e1.clone();

        e2.address.city = "Delhi";

        System.out.println(e2.address.city);
    }
}
