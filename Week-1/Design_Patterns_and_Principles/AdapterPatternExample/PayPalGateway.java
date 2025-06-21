package AdapterPatternExample;
public class PayPalGateway {
    public void makePayment(double amountInDollars) {
        System.out.println("Processing PayPal payment of $" + amountInDollars);
    }
}
