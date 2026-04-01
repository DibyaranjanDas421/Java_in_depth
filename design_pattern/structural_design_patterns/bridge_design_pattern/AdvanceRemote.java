package design_pattern.structural_design_patterns.bridge_design_pattern;

public class AdvanceRemote extends Remote {

    public AdvanceRemote(Device device) {
        super(device);
    }

    public void setVolume(){
        device.setVolume();
    }

}
