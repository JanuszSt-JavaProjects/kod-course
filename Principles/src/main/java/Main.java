import java.math.BigDecimal;

public class Main {


    public static void main(String[] args) {
        ProductOrderService orderService = new ProductOrderService(new TemporaryDatabase_Customers(), new TemporaryDatabase_Products());

        Customer jan_kowalski = new Customer("Jan", "Kowalski", 0);
        Customer john_smith = new Customer("John", "Smith", 0);

        Product hacksaw = new Product("SIMPLE_TOOLS", "Hacksaw", "ITEM", BigDecimal.valueOf(100));
        Product chainsaw = new Product("SIMPLE_TOOLS", "Chainsaw", "ITEM", BigDecimal.valueOf(800));
        Product hammer = new Product("SIMPLE_TOOLS", "Hammer", "ITEM", BigDecimal.valueOf(50));

        // check:

        orderService.createOrder(john_smith, hacksaw);
        System.out.println(orderService.getOrder());
        System.out.println();

        orderService.addProductToCurrentCustomer(hammer);
        System.out.println("\n" + orderService.getOrder());
        System.out.println();

        orderService.createOrder(jan_kowalski, hacksaw);
        System.out.println(orderService.getOrder());

        System.out.println();
        orderService.createOrder(jan_kowalski, chainsaw);

        System.out.println(orderService.getOrder());
    }

}
