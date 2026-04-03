package design_pattern.structural_design_patterns.composite_design_pattern;

import java.util.ArrayList;
import java.util.List;

public class Folder implements Component {

    private String name;
    private List<Component> components = new ArrayList<>();

    Folder(String name) {
        this.name = name;
    }

    public void add(Component c) {
        components.add(c);
    }

    public void remove(Component c) {
        components.remove(c);
    }

    @Override
    public void show() {
        System.out.println("Folder :" + name);
        for (Component c : components) {
            c.show();
        }
    }

}
