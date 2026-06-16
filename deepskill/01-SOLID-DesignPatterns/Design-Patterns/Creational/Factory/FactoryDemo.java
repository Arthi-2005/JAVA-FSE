package Creational.Factory;

public class FactoryDemo {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape s1 = factory.getShape("CIRCLE");
        Shape s2 = factory.getShape("RECTANGLE");
        s1.draw();
        s2.draw();
    }
}
