package CustomerOrderSorter;

public class OrderSortTest {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(101, "Harini", 2500),
            new Order(102, "Abinaya", 1800),
            new Order(103, "Sathya", 5400),
            new Order(104, "Ravi", 1300)
        };

        System.out.println("Original Orders:");
        for (Order o : orders) System.out.println(o);

        // Bubble Sort
        SortAlgorithms.bubbleSort(orders);
        System.out.println("\nOrders Sorted by Bubble Sort:");
        for (Order o : orders) System.out.println(o);

        // Reset orders
        orders = new Order[]{
            new Order(101, "Harini", 2500),
            new Order(102, "Abinaya", 1800),
            new Order(103, "Sathya", 5400),
            new Order(104, "Ravi", 1300)
        };

        // Quick Sort
        SortAlgorithms.quickSort(orders, 0, orders.length - 1);
        System.out.println("\nOrders Sorted by Quick Sort:");
        for (Order o : orders) System.out.println(o);
    }
}
