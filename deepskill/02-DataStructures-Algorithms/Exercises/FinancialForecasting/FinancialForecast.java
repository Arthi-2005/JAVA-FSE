package Exercises.FinancialForecasting;

public class FinancialForecast {
    public static double predictFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) return currentValue;
        return predictFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static double predictFutureValueOptimized(double currentValue, double growthRate, int years) {
        return currentValue * Math.pow(1 + growthRate, years);
    }

    public static void main(String[] args) {
        double currentValue = 10000;
        double growthRate = 0.05;
        int years = 10;

        double recursive = predictFutureValue(currentValue, growthRate, years);
        double optimized = predictFutureValueOptimized(currentValue, growthRate, years);

        System.out.println("Recursive Forecast: $" + String.format("%.2f", recursive));
        System.out.println("Optimized Forecast: $" + String.format("%.2f", optimized));
        System.out.println("Time Complexity: O(n) recursive, O(1) optimized");
    }
}
