package Map.EnumMap;

import java.util.EnumMap;

public class EnumMapExample {

    public static void main(String[] args) {

        EnumMap<Day, Integer> map = new EnumMap<>(Day.class);
        map.put(Day.MONDAY, 1);
        map.put(Day.THRUSDAY, 2);

        System.out.println(map);
        System.out.println(map.get(Day.MONDAY));
        System.out.println(Day.MONDAY.ordinal());
    }

}
