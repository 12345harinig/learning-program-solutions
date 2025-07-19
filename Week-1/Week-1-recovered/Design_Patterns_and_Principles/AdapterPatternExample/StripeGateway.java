package AdapterPatternExample;

public class StripeGateway {
    public void sendPayment(double money) {
        System.out.println("Processing Stripe payment of $" + money);
    }
}
