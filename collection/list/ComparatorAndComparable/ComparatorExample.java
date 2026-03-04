package collection.list.ComparatorAndComparable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(89);
        list.add(77);
        list.add(98);

        list.sort(null);

        System.out.println(list);
        // here .sort() will take an funtional interface impl so i used lamba
        // expressoion
        // for this
        list.sort((o1, o2) -> o2 - o1);
        System.out.println(list);

        List<String> name = new ArrayList<>();
        name.add("Dibya");
        name.add("Ankeet");
        name.add("Debu");
        name.add("Anusmita");
        // natural ordering
        name.sort(null);

        System.out.println(name);
        name.sort(new StringComparator());
        System.out.println(name);

        Student s1 = new Student(101, "Rahul", 21, "Computer Science", 88.5);
        Student s2 = new Student(101, "Munal", 22, "Computer Science", 89.5);

        Student s3 = new Student(101, "Deepa", 23, "Computer Science", 98.5);

        Student s4 = new Student(101, "Rohit", 24, "Computer Science", 97.5);

        List<Student> stud = new ArrayList<>();
        stud.addAll(Arrays.asList(s1, s2, s3, s4));
        System.out.println(stud);

        Comparator<Student> compo = Comparator.comparing(Student::getMarks).reversed().thenComparing(Student::getAge);
        stud.sort(compo);
        System.out.println(stud);

    }

}

class StringComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o2.length() - o1.length();
    }

}

class Student {

    // Fields
    private int id;
    private String name;
    private int age;
    private String course;
    private double marks;

    // Constructor
    public Student(int id, String name, int age, String course, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.marks = marks;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    public double getMarks() {
        return marks;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    // Override toString()
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", course='" + course + '\'' +
                ", marks=" + marks +
                '}';
    }
}
