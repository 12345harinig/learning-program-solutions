package DependencyInjectionExample;

public class DependencyInjectionTest {
    public static void main(String[] args) {
        // Create repository implementation
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Inject repository into service
        CustomerService service = new CustomerService(repository);

        // Use the service
        service.displayCustomerById(1);
        service.displayCustomerById(2);
        service.displayCustomerById(3); // Not found
    }
}
