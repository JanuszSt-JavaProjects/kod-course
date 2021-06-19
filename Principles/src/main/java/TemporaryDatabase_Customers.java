import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TemporaryDatabase_Customers implements CustomerDatabaseServices {

    private final Set<Customer> customersDatabase = new HashSet<>(Arrays.asList(
            new Customer("John", "Smith", 0),
            new Customer("Michael", "Black", 1)
    ));


    @Override
    public boolean exists(Customer customer) {
        return customersDatabase.contains(customer);
    }

    @Override
    public boolean add(Customer customer) {
        return customersDatabase.add(customer);
    }

    @Override
    public String toString() {
        return "TemporaryDatabase_Customers{" +
                "customersDatabase=" + customersDatabase +
                '}';
    }
}
