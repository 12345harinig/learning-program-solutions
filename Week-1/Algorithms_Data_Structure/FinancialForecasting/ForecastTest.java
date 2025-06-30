package FinancialForecasting;

public class ForecastTest {
    public static void main(String[] args) {
        double initialAmount = 10000.0;     // Rs.10,000
        double growthRate = 0.10;           // 10% per year
        int years = 5;

        double result = FinancialForecast.calculateFutureValue(initialAmount, growthRate, years);
        System.out.printf(" Future value after %d years: ₹%.2f\n", years, result);

        // Optimized approach for larger input
        Double[] memo = new Double[years + 1];
        double optimizedResult = FinancialForecast.calculateFutureValueMemo(initialAmount, growthRate, years, memo);
        System.out.printf(" Optimized future value after %d years: ₹%.2f\n", years, optimizedResult);
    }
}
