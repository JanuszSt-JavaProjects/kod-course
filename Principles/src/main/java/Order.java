import java.util.ArrayList;
import java.util.List;

public class Order {

    private Customer customer;
    private final List<Product> orderedProductsList = new ArrayList<>();

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void addProduct(Product product) {
        orderedProductsList.add(product);
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", orderedProductsList=" + orderedProductsList +
                '}';
    }
}
