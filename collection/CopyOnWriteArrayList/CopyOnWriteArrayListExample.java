package collection.CopyOnWriteArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {

    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>(Arrays.asList("Bread", "Jam", "Sos"));

        for (String element : list) {
            if (element.equals("Bread")) {
                list.add("Butter"); // give concurrent modification exception in case of ArrayList
            }
        }
        System.out.println(list);
    }

}
