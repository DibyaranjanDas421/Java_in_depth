package collection.list.ComparatorAndComparable;

import java.util.ArrayList;
import java.util.Comparator;

public class ComparableExample {

    public static void main(String[] args) {
        ArrayList<Student1> stud = new ArrayList<>();

        stud.add(new Student1("Dibya", 7));
        stud.add(new Student1("Ankket", 7));

        System.out.println(stud);

        stud.sort(null);
        System.out.println(stud);

        stud.sort(Comparator.comparing(Student1::getGpa));
        System.out.println(stud);
        stud.sort(Comparator.comparing(Student1::getGpa).reversed());
        System.out.println(stud);
        stud.sort(
                Comparator.comparing(Student1::getGpa, Comparator.reverseOrder())
                        .thenComparing(
                                s -> s.getName().length(),
                                Comparator.reverseOrder()));
        System.out.println(stud);

    }

}

class Student1 implements Comparable<Student1> {
    private String name;
    private int gpa;

    public Student1(String name, int gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public int getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }

    @Override
    public int compareTo(Student1 o) {
        return Double.compare(o.getGpa(), this.getGpa());
    }

}
