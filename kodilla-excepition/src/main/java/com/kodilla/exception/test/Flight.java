package com.kodilla.exception.test;

public class Flight {

    private final String departureAirport = "New York";
    private String arrivalAirport;

    public Flight(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;

    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }
}
