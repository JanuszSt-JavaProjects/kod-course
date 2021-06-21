package supply;

import java.math.BigDecimal;

public class Product {

    private final String name;
    private final BigDecimal price;
    private final double quantity;

    public Product(String name, BigDecimal price, double quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
