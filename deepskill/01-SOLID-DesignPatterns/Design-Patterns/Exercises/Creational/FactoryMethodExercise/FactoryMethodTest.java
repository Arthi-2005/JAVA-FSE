package Exercises.Creational.FactoryMethodExercise;

public class FactoryMethodTest {
    public static void main(String[] args) {
        DocumentFactory factory = new WordFactory();
        Document doc = factory.createDocument();
        doc.open(); doc.save(); doc.close();

        factory = new PdfFactory();
        doc = factory.createDocument();
        doc.open(); doc.save(); doc.close();

        factory = new ExcelFactory();
        doc = factory.createDocument();
        doc.open(); doc.save(); doc.close();
    }
}
