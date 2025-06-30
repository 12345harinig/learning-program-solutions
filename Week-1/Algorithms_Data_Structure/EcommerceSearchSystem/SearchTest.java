package EcommerceSearchSystem;
public class SearchTest {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Footwear"),
            new Product(103, "Keyboard", "Electronics"),
            new Product(104, "Watch", "Accessories"),
            new Product(105, "Phone", "Electronics")
        };

        // Linear Search
        Product result1 = SearchAlgorithms.linearSearch(products, "Watch");
        System.out.println("Linear Search Result: " + (result1 != null ? result1 : "Not found"));

        // Binary Search
        Product result2 = SearchAlgorithms.binarySearch(products, "Keyboard");
        System.out.println("Binary Search Result: " + (result2 != null ? result2 : "Not found"));
    }
}
