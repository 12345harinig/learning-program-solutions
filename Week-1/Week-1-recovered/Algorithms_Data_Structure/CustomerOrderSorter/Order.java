package CustomerOrderSorter;
public class Order {
    private int orderId;
    private String customerName;
    private double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String toString() {
        return "Order [ID=" + orderId + ", Customer=" + customerName + ", Price=₹" + totalPrice + "]";
    }
}
