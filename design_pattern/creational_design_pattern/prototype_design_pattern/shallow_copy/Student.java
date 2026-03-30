package design_pattern.creational_design_pattern.prototype_design_pattern.shallow_copy;

public class Student implements Cloneable {

    Integer id;
    String name;

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
