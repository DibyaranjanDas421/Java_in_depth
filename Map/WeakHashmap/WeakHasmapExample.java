package Map.WeakHashmap;

import java.util.WeakHashMap;

public class WeakHasmapExample {

    public static void main(String[] args) {
        WeakHashMap<String, Image> wh = new WeakHashMap<>();

        String key1 = new String("img1");
        String key2 = new String("img2");

        wh.put(key1, new Image("Dibya_img"));
        wh.put(key2, new Image("Debu_img"));
        System.out.println(wh);
        key1 = null;
        key2 = null;

        System.gc();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(wh);
    }

}

class Image {

    private String name;

    public String getName() {
        return name;
    }

    public Image(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
