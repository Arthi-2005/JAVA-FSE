package Exercises.Creational.FactoryMethodExercise;

public class ExcelFactory extends DocumentFactory {
    @Override
    public Document createDocument() { return new ExcelDocument(); }
}
