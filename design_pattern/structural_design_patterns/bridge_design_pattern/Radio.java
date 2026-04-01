package design_pattern.structural_design_patterns.bridge_design_pattern;

public class Radio implements Device {
    @Override
    public void powerOn() {
        System.out.println("Radio on!");
    }

    @Override
    public void powerOf() {
        System.out.println("Radio of!");

    }

    @Override
    public void setVolume() {
        System.out.println("Increasing Radio volume!");

    }
}
