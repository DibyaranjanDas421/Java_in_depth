package Inheritance;

public class InheritanceExample {

    public static void main(String[] args) {
        Child c = new Child();
        System.out.println(c.a);
        // System.out.println(c.b);
        System.out.println(c.c);

    }

}

class Parent {
    Integer a;
    private Integer b;
    protected Integer c;

}

class Child extends Parent {

}