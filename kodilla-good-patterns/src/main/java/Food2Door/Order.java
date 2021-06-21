package Food2Door;

import java.util.List;

public class Order {
    private final Producer producer;
    private final List<Product> productsList;

    public Order(Producer producer, List<Product> productsList) {
        this.producer = producer;
        this.productsList = productsList;
    }

    @Override
    public String toString() {
        return "\nOrder:" +
                "\nproducer: " + producer +
                "\nproductsList:\n" + productsList;

    }
}
