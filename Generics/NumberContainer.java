package Generics;

public interface NumberContainer<T extends Number> {

    void add(T item);

    T get();

}
