package design_pattern.structural_design_patterns.bridge_design_pattern;

public class Tv implements Device {

    @Override
    public void powerOn() {
        System.out.println("TV on!");
    }

    @Override
    public void powerOf() {
        System.out.println("TV of!");

    }

    @Override
    public void setVolume() {
        System.out.println("Increasing TV volume!");

    }

}
