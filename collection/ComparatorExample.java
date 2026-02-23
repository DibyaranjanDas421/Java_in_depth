package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(89);
        list.add(77);
        list.add(98);

        list.sort(null);

        System.out.println(list);
        // here .sor() will take an funtional interface impl so i used lamba expressoion
        // for this
        list.sort((o1, o2) -> o2 - o1);
        System.out.println(list);

        List<String> name = new ArrayList<>();
        name.add("Dibya");
        name.add("Ankeet");
        name.add("Debu");
        name.add("Anusmita");
        // natural ordering
        name.sort(null);

        System.out.println(name);
        name.sort(new StringComparator());
        System.out.println(name);

    }

}

class StringComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o2.length() - o1.length();
    }

}
