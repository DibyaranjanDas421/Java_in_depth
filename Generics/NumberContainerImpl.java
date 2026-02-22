package Generics;

public class NumberContainerImpl implements NumberContainer<Integer> {

    private Integer item;

    @Override
    public void add(Integer item) {
        this.item = item;
    }

    @Override
    public Integer get() {
        return item;
    }

}
