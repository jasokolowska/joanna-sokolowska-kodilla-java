package com.kodilla.good.patterns.challenges.flights;

public class Main {
    public static void main(String[] args) {
        FlightSearch flightSearch = new FlightSearch();

        System.out.println("Find all flights from Wroclaw Airport:\n"
                + flightSearch.findDestinationsFromAirport("WROCLAW"));

        System.out.println("Find all flights to Barcelona:\n"
                + flightSearch.findFlightsToDestination("BARCELONA"));

        System.out.println("Find all flights to Barcelona via Warsaw\n" +
                flightSearch.findFlightsWithConnection("BARCELONA", "WARSZAWA"));
    }
}
