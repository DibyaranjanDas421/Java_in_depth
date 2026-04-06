package design_pattern.structural_design_patterns.decorator_design_pattern;

public abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public double cost() {
        return coffee.cost();
    }

    public String description() {
        return coffee.description();
    }

}
