package Generics;

class MyClass<T> {
    public static <U> void staticMethod(U param) {
        System.out.println(param);
    }
}