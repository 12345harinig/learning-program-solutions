package AdapterPatternExample;

public class PaymentTest {
    public static void main(String[] args) {
         PayPalGateway paypal = new PayPalGateway();
        PaymentProcessor paypalAdapter = new PayPalAdapter(paypal);
        paypalAdapter.processPayment(250.0);

        StripeGateway stripe = new StripeGateway();
        PaymentProcessor stripeAdapter = new StripeAdapter(stripe);
        stripeAdapter.processPayment(400.0);
    }
}
