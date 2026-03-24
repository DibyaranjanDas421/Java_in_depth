package polymorphism.compiletimepolymorphism;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // public double add(int a,int b){
    // return (a+b); //not work
    // }

    public double add(double a, double b) {
        return a + b;
    }

}
