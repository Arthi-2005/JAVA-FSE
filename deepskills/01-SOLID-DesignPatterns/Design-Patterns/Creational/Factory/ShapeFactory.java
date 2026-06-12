package Creational.Factory;

public class ShapeFactory {
    public Shape getShape(String type) {
        if (type.equalsIgnoreCase("CIRCLE")) return new Circle();
        else if (type.equalsIgnoreCase("RECTANGLE")) return new Rectangle();
        return null;
    }
}
