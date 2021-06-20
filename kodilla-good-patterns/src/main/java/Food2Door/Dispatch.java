package Food2Door;

public class Dispatch {

    private final String destination;
    private final Order order;

    public Dispatch(String destination, Order order) {
        this.destination = destination;
        this.order = order;
    }

    public String getDestination() {
        return destination;
    }
}
