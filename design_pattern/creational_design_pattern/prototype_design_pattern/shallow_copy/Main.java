package design_pattern.creational_design_pattern.prototype_design_pattern.shallow_copy;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Student s1 = new Student(1, "Dibya");

        Student s2 = (Student) s1.clone();

        s2.name = "Ankeet";

        System.out.println(s2.name);
    }

}
