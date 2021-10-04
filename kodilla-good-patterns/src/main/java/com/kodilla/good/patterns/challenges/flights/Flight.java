package com.kodilla.good.patterns.challenges.flights;

public class Flight {
    private String departureAirport;
    private String arrivalAirport;
    private String connectionAirport;
    private boolean connection;

    public Flight(String departureAirport, String arrivalAirport) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.connection = false;
    }

    public Flight(String departureAirport, String arrivalAirport, String connectionAirport) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.connectionAirport = connectionAirport;
        this.connection = true;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    @Override
    public String toString() {
        if (connection) {
            return departureAirport + " -> " + connectionAirport + " -> " + arrivalAirport;
        } else {
            return departureAirport + " -> " + arrivalAirport;
        }
    }
}
