public interface CustomerDatabaseServices {

    boolean exists(Customer customer);

    boolean add(Customer customer);
}
