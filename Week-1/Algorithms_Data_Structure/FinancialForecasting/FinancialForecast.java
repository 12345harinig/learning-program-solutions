package FinancialForecasting;

public class FinancialForecast {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double initialAmount, double growthRate, int years) {
        if (years == 0) {
            return initialAmount;
        }
        return (1 + growthRate) * calculateFutureValue(initialAmount, growthRate, years - 1);
    }

    // Optimized version using memoization (if needed for large inputs)
    public static double calculateFutureValueMemo(double initialAmount, double growthRate, int years, Double[] memo) {
        if (years == 0) return initialAmount;
        if (memo[years] != null) return memo[years];
        memo[years] = (1 + growthRate) * calculateFutureValueMemo(initialAmount, growthRate, years - 1, memo);
        return memo[years];
    }
}

