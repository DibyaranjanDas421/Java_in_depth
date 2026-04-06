package design_pattern.structural_design_patterns.decorator_design_pattern;

public class SimpleCoffee implements Coffee {

    @Override
    public double cost() {
        return 100;
    }

    @Override
    public String description() {
        return "Simple Coffee";

    }

}
