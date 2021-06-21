package Fly_company;

public class Connection {
    private final City departure;
    private final City arrival;

    public Connection(City departure, City arrival) {
        this.departure = departure;
        this.arrival = arrival;
    }

    public City getDeparture() {
        return departure;
    }

    public City getArrival() {
        return arrival;
    }

    @Override
    public String toString() {
        return "Connection from: " + departure + " to:  " + arrival;
    }
}
