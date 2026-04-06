package design_pattern.structural_design_patterns.decorator_design_pattern;

class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public double cost() {
        return coffee.cost() + 20;
    }

    public String description() {
        return coffee.description() + ", Milk";
    }
}
