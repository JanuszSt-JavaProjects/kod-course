public interface CustomerDatabaseServices {

    boolean isInCustomerDatabase(Customer customer);

    boolean addToCustomerDatabase(Customer customer);
}
