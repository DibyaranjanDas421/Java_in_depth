package Generics;

public class GenericInterfaceImpl<T> implements GenericInterface<T> {

    private T item;

    @Override
    public void add(T item) {
        this.item = item;
    }

    @Override
    public T get() {
        return item;
    }

}
