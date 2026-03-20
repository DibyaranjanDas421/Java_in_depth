package design_pattern.creational_design_pattern.singleton;

public class EagerInitialization {

    public static final EagerInitialization instance = new EagerInitialization();

    private EagerInitialization() {
    }

    public static EagerInitialization getInstance() {
        return instance;
    }

}
