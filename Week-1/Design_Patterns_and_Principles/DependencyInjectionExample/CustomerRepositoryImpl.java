package DependencyInjectionExample;
import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private Map<Integer, Customer> customers = new HashMap<>();

    public CustomerRepositoryImpl() {
        customers.put(1, new Customer(1, "Harini"));
        customers.put(2, new Customer(2, "Ammu"));
    }

    @Override
    public Customer findCustomerById(int id) {
        return customers.getOrDefault(id, null);
    }
}
