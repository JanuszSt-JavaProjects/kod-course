import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private final String category;
    private final String name;
    private final String unitOfMeasure;
    private final BigDecimal pricePerItem;

    public Product(String category, String name, String unitOfMeasure, BigDecimal pricePerItem) {
        this.category = category;
        this.name = name;
        this.unitOfMeasure = unitOfMeasure;
        this.pricePerItem = pricePerItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(category, product.category) && Objects.equals(name, product.name) && Objects.equals(unitOfMeasure, product.unitOfMeasure) && Objects.equals(pricePerItem, product.pricePerItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, name, unitOfMeasure, pricePerItem);
    }

    @Override
    public String toString() {
        return "Product{" +
                "category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", unitOfMeasure='" + unitOfMeasure + '\'' +
                ", pricePerItem=" + pricePerItem +
                '}';
    }
}
