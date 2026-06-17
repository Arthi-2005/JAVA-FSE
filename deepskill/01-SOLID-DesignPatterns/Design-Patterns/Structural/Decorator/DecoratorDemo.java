package Structural.Decorator;

public class DecoratorDemo {
    public static void main(String[] args) {
        Coffee coffee = new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
        System.out.println(coffee.getDescription() + " = $" + coffee.getCost());
    }
}
