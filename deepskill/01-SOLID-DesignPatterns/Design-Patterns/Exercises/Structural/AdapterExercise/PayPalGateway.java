package Exercises.Structural.AdapterExercise;

public class PayPalGateway {
    public void sendPayment(double usd) {
        System.out.println("Processing $" + usd + " via PayPal");
    }
}
