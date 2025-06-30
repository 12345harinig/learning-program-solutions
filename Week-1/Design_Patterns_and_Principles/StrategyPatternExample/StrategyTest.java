package StrategyPatternExample;

public class StrategyTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
context.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432", "Harini G"));
context.processPayment(1500.0);
context.setPaymentStrategy(new PayPalPayment("harini.pay@example.com"));
        context.processPayment(800.0);
    }
}

