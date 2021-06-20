package Food2Door;

import Food2Door.producers.ExtraFoodShop;
import Food2Door.producers.GlutenFreeShop;
import Food2Door.producers.HealthyShop;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> productsList1 = Arrays.asList(new Product("extra Food 1", 1, new BigDecimal(10)),
                new Product("extra Food 2 ", 100, new BigDecimal(50)));


        Processor processor = new Processor(new ExtraFoodShop(), productsList1, "First Destination");
        processor.execute();

        System.out.println();

        processor = new Processor(new GlutenFreeShop(), productsList1, "First Destination");
        processor.execute();


        processor = new Processor(new HealthyShop(), productsList1, "First Destination");
        processor.execute();

        System.out.println();
    }
}
