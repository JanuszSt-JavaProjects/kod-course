public class ProductOrderService {
    private CustomerDatabaseServices customerService;
    private ProductDatabaseServices productService;
    private Order order;


    public ProductOrderService(CustomerDatabaseServices customerService, ProductDatabaseServices productService) {//to constr.
        this.customerService = customerService;
        this.productService = productService;
        System.out.println(customerService.toString() + "\n" + productService.toString());

    }

    boolean createOrder(Customer customer, Product product) {
        order = new Order();
        order.setCustomer(customer);
        if (!customerService.exists(customer)) {
            customerService.add(customer);
            System.out.println("customer added --------------");
        }
        if (!productService.isAccessible(product)) {
            // any action to do
            System.out.println("No product available --------------");

            return false;
        }
        addProductToCurrentCustomer(product);
        System.out.println("product Added to Your shopping Cart");


        return true;
    }

    void addProductToCurrentCustomer(Product product) {
        order.addProduct(product);
    }

    void sendOrderToExecute(final Order order) {

        // any action to do
    }

    Order getOrder() {
        return order;
    }

}



