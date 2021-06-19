import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TemporaryDatabase_Products implements ProductDatabaseServices {


    private final Set<Product> productsDatabase = new HashSet<>(Arrays.asList(
            new Product("SIMPLE_TOOLS", "Hammer", "ITEM",
                    BigDecimal.valueOf(50)),
            new Product("SIMPLE_TOOLS", "Nails", "Kg", BigDecimal.valueOf(20)),
            new Product("SIMPLE_TOOLS", "Hacksaw", "ITEM", BigDecimal.valueOf(100))

    ));

    @Override
    public boolean isAccessible(Product product) {
        System.out.println(productsDatabase);
        return productsDatabase.contains(product);
    }
}
