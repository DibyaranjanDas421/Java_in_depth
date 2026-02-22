package Generics;

import java.util.List;

public class WildCardsInGenerics {

    public void printList(List<?> list) {
        for (Object element : list) {
            System.out.println(element);
        }
    }
}
