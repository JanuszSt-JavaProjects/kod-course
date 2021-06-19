package supply;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Producer extraFoodShop = new Producer("ExtraFoodShop");
        Producer glutenFreeShop = new Producer("GlutenFreeShop");
        Producer healthyShop = new Producer("HealthyShop");


        List<Product> productsList1 = Arrays.asList(new Product("extra Food 1", new BigDecimal(10), 1),
                new Product("extra Food 2 ", new BigDecimal(50), 100));
        List<Product> productsList2 = Arrays.asList(new Product("Gluten Free prod.1 ", new BigDecimal(18), 25),
                new Product("Gluten Free prod.2", new BigDecimal(135), 1000));

        System.out.println("First process: \n");
        ShippingProcessor shippingProcessorEF = new ShippingProcessor(
                extraFoodShop, true, "Quality Mark Certification Adding ");
        shippingProcessorEF.process("Any Destination", productsList1);

        System.out.println("\n Second  process:");

        ShippingProcessor shippingProcessorGFS = new ShippingProcessor(glutenFreeShop);
        shippingProcessorGFS.process("Any other destination", productsList2);

    }
}
