package ObserverPatternExample;

public class ObserverPatternTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileHarini = new MobileApp("Harini");
        Observer webAmmu = new WebApp("Ammu");

        stockMarket.registerObserver(mobileHarini);
        stockMarket.registerObserver(webAmmu);

        // First stock price change
        stockMarket.setStock("TCS", 3750.00);
        stockMarket.setStock("Infosys", 1555.00);
        stockMarket.removeObserver(webAmmu);
        stockMarket.setStock("Wipro", 456.75);
    }
}
