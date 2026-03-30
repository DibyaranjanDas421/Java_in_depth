package design_pattern.creational_design_pattern.prototype_design_pattern.deep_copy;

public class Employee implements Cloneable {
    Integer id;
    String name;
    Address address;

    Employee(Integer id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;

    }

    protected Object clone() throws CloneNotSupportedException {
        Employee emp = (Employee) super.clone();
        emp.address = new Address(this.address.city);
        return emp;
    }
}
