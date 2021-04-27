package com.kodilla.exception.test;

public class FlightCheckApplication {


    public static void main(String[] args) {

        FlightConnectionCheck flightChecker = new FlightConnectionCheck();
        String destination = "Warsaw";

        try {
            flightChecker.findFlight(new Flight(destination));
        } catch (RouteNotFoundException e) {

            e.printStackTrace();
        }


    }
}
