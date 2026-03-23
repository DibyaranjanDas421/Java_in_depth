package constructor;

// Parent class A
class A {
    A() {
        // This constructor will be called first when creating object of child class B
        System.out.println("A called");
    }
}

// Child class B extending A
class B extends A {
    B() {
        // super() is implicitly called here → calls A()
        System.out.println("B called");
    }
}

// Class demonstrating constructor with exception
class C {
    C() {
        System.out.println("Constructor called for C");
        // Throwing exception → object creation will stop here
        throw new RuntimeException("Stopping to create constructor");
    }
}

public class ConstructorExample {

    // Instance variables (default values: null)
    Integer num;
    String name;
    String college;

    // Default constructor
    ConstructorExample() {
        // No initialization → all variables remain default (null)
    };

    // Parameterized constructor (1 parameter)
    ConstructorExample(Integer num) {
        // ❌ Wrong assignment (common mistake)
        // This assigns parameter to itself, NOT instance variable
        num = num;
    };

    // Parameterized constructor (2 parameters)
    ConstructorExample(Integer num, String name) {
        // Calling another constructor (constructor chaining)
        // MUST be first statement
        this(10, "Dibya", "IITB");

        // Assigning values to instance variables
        this.num = num;
        this.name = name;
    };

    // Parameterized constructor (3 parameters)
    ConstructorExample(Integer num, String name, String college) {
        // Proper initialization of instance variables
        this.num = num;
        this.name = name;
        this.college = college;

        System.out.println("Parameterized constructor called");
    };

    public static void main(String[] args) {

        // Calling default constructor
        ConstructorExample c = new ConstructorExample();
        // num is not initialized → prints null
        System.out.println(c.num);

        // Calling 1-arg constructor
        ConstructorExample c1 = new ConstructorExample(10);
        // Still null because of wrong assignment (num = num)
        System.out.println(c1.num);

        // Calling 2-arg constructor
        ConstructorExample c2 = new ConstructorExample(10, "Dibya");
        // First calls 3-arg constructor → then sets values again
        System.out.println(c2.name);

        // Creating object of B
        // First A() runs → then B()
        B b = new B();

        // Creating object of C
        // Constructor prints message → then throws exception
        // Program will terminate here (next lines won't execute)
        C cc = new C();
    }
}