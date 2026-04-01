package design_pattern.structural_design_patterns.bridge_design_pattern;

public class Main {

    public static void main(String[] args) {
        Device tv = new Tv();
        Remote remote = new AdvanceRemote(tv);

        remote.turnOn();
        remote.turnOf();
        ((AdvanceRemote) remote).setVolume();

        Device radio = new Radio();
        Remote remote2 = new AdvanceRemote(radio);
        ((AdvanceRemote) remote2).setVolume();

    }

}
