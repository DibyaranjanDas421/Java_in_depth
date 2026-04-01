package design_pattern.structural_design_patterns.bridge_design_pattern;

public class Remote {

    protected Device device;

    public Remote(Device device) {
        this.device = device;
    }

    public void turnOn() {
        device.powerOn();
    }

    public void turnOf() {
        device.powerOf();

    }

}
