package Fly_company;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ConnectionFinder {

    private final Set<Connection> connections;

    public ConnectionFinder() {
        TemporaryDatabase_Connections connectObject = new TemporaryDatabase_Connections();
        connections = connectObject.getConnections();
    }

    Set<Connection> findDirectConnection(City departureCity, City arrivalCity) {

        return connections.stream()
                .filter(x -> (x.getDeparture().equals(departureCity) && x.getArrival().equals(arrivalCity)))
                .peek(System.out::println)
                .collect(Collectors.toSet());
    }

    Set<Connection> findIndirectConnection(City departureCity, City arrivalCity) {

        Set<Connection> connectionSet = new HashSet<>();

        Set<Connection> fromCity = connections.stream()
                .filter(x -> x.getDeparture().equals(departureCity))
                .collect(Collectors.toSet());

        Set<Connection> toCity = connections.stream()
                .filter(x -> x.getArrival().equals(arrivalCity))
                .collect(Collectors.toSet());

        for (Connection x : fromCity) {

            for (Connection y : toCity) {
                if (x.getArrival().equals(y.getDeparture())) {
                    connectionSet.add(x);
                    System.out.println(departureCity + " to " + arrivalCity + " via: " + x.getArrival());
                }
            }
        }
        return connectionSet;
    }


    Set<Connection> connectionToCity(City arrivalCity) {
        return connections.stream()
                .filter(x -> x.getArrival().equals(arrivalCity))
                .peek(System.out::println)
                .collect(Collectors.toSet());
    }


    Set<Connection> connectionFromCity(City departureCity) {
        return connections.stream()
                .filter(x -> x.getDeparture().equals(departureCity))
                .peek(System.out::println)
                .collect(Collectors.toSet());

    }

}
