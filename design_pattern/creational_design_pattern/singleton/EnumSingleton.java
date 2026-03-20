package design_pattern.creational_design_pattern.singleton;

public class EnumSingleton {
    public static void main(String[] args) {
        singleton s = singleton.INSTANCE;
    }

}

enum singleton {
    INSTANCE;
}
