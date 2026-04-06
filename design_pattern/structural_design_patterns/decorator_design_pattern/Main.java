package design_pattern.structural_design_patterns.decorator_design_pattern;

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();

        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);

        System.out.println(coffee.description());
        System.out.println(coffee.cost());

    }

}
