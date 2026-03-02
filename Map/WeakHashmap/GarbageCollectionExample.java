package Map.WeakHashmap;

import java.lang.ref.WeakReference;

public class GarbageCollectionExample {

    public static void main(String[] args) {
        Phone p = new Phone("Dibya");
        System.out.println(p);
        p = null;
        System.gc();
        WeakReference<Phone> wf = new WeakReference<Phone>(new Phone("Dibya"));
        System.out.println(wf.get());

        System.gc();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(wf.get());

    }

}

class Phone {

    private String name;

    public String getName() {
        return name;
    }

    public Phone(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;

    }

}
