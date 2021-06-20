package Fly_company;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConnectionFinder {

    private final Set<Connection> connections;

    public ConnectionFinder() {
        TemporaryDatabase_Connections connectObject = new TemporaryDatabase_Connections();
        connections = connectObject.getConnections();
    }

    void directConnectionFind(City departureCity, City arrivalCity) {

        connections.stream()
                .filter(x -> (x.getDeparture().equals(departureCity) && x.getArrival().equals(arrivalCity)))
                .forEach(System.out::println);
    }

    void indirectConnectionFind(City departureCity, City arrivalCity) {

        Set<Connection> fromCity = connections.stream()
                .filter(x -> x.getDeparture().equals(departureCity))
                .collect(Collectors.toSet());

        Set<Connection> toCity = connections.stream()
                .filter(x -> x.getArrival().equals(arrivalCity))
                .collect(Collectors.toSet());

        for (Connection x : fromCity) {

            for (Connection y : toCity) {
                if (x.getArrival().equals(y.getDeparture())) {
                    System.out.println(departureCity + " to " + arrivalCity + " via: " + x.getArrival());
                }
            }
        }
    }


    public void connectionToCity(City arrivalCity) {
        connections.stream()
                .filter(x -> x.getArrival().equals(arrivalCity))
                .forEach(System.out::println);
    }


    void connectionFromCity(City departureCity) {
        connections.stream()
                .filter(x -> x.getDeparture().equals(departureCity))
                .forEach(System.out::println);

    }

}
