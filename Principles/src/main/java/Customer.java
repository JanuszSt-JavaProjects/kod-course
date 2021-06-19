import java.util.Objects;

public class Customer {

    private final String firstname;
    private final String surname;
    private final int Id;

    public Customer(String firstname, String surname, int id) {
        this.firstname = firstname;
        this.surname = surname;
        Id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Id == customer.Id && Objects.equals(firstname, customer.firstname) && Objects.equals(surname, customer.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, surname, Id);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstname + '\'' +
                ", surName='" + surname + '\'' +
                ", Id=" + Id +
                '}';
    }
}
