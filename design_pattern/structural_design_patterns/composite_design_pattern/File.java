package design_pattern.structural_design_patterns.composite_design_pattern;

public class File implements Component {

    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        System.out.println("File: " + name);
    }

}
