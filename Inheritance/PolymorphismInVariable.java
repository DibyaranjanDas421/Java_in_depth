package Inheritance;

public class PolymorphismInVariable {
    public static void main(String[] args) {
        College c = new Branch();
        System.out.println(c.student);
        c.show();
    }
}

class College {

    int student = 10;

    public void show() {
        System.out.println("you are under college");
    }

}

class Branch extends College {
    int student = 5;

    @Override
    public void show() {
        System.out.println("you are under Branch");
    }

}
