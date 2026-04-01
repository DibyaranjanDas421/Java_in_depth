package static_keyword;

public class StaticExample {

    int rollNo = 0;
    public static int collegeCode = 0;

    public StaticExample() {
        rollNo++;
        collegeCode++;
    }

    static void show() {
        // System.out.println("Showing collegeCode" + rollNo);
    }

    public static void main(String[] args) {
        StaticExample se = new StaticExample();
        System.out.println("se-roll :" + se.rollNo);
        System.out.println("se-collegeCode :" + se.collegeCode);
        StaticExample se1 = new StaticExample();
        System.out.println("se2-roll :" + se1.rollNo);
        System.out.println("se1-collegeCode :" + se1.collegeCode);
        StaticExample se2 = new StaticExample();
        System.out.println("se2-roll :" + se2.rollNo);
        System.out.println("se2-collegeCode :" + se2.collegeCode);
    }
}
