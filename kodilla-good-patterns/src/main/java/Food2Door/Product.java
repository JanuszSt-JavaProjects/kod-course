package Food2Door;

import java.math.BigDecimal;

public class Product {
    private final String name;
    private final double quantity;
    private final BigDecimal price;

    public Product(String name, double quantity, BigDecimal price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product:" +
                "name=" + name +
                ", quantity=" + quantity +
                ", price=" + price;
    }
}
