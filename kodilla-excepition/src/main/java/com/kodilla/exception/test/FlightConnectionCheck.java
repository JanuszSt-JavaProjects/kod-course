package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightConnectionCheck {

    private HashMap<String, Boolean> getActuallyAccessibleAirports() {
        Map<String, Boolean> actuallyAccessibleAirports = new HashMap<>();

        actuallyAccessibleAirports.put("Warsaw", true);
        actuallyAccessibleAirports.put("Prague", true);
        actuallyAccessibleAirports.put("Oslo", false);
        actuallyAccessibleAirports.put("Madrid", true);
        actuallyAccessibleAirports.put("Ankara", false);
        actuallyAccessibleAirports.put("Cairo", false);
        return new HashMap<>(actuallyAccessibleAirports);
    }


    boolean findFlight(Flight flight) throws RouteNotFoundException {
        HashMap<String, Boolean> accessibleDestinations = getActuallyAccessibleAirports();

        if (!accessibleDestinations.containsKey(flight.getArrivalAirport())) {
            System.out.println("We are sorry, but our Lines do not offer this connection.");
            throw new RouteNotFoundException(" - there is no such destination in the database!");
        } else {
            boolean trueMarker = accessibleDestinations.get(flight.getArrivalAirport());

            if (trueMarker) System.out.println("Your Destination is available.");
            else System.out.println("Your Destination is temporarily not available.");

            return trueMarker;
        }
    }
}
