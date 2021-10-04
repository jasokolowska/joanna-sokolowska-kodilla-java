package com.kodilla.good.patterns.challenges.flights;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FlightSearch {

    private AirportsGenerator airports;

    public FlightSearch() {
        this.airports = new AirportsGenerator();
    }

    public List<Flight> findDestinationsFromAirport(String departureAirport) {
        return airports.getAirports().stream()
                .filter(a -> a.getName().equals(departureAirport))
                .map(Airport::getDestinations)
                .flatMap(List::stream)
                .map(destination -> new Flight(departureAirport, destination))
                .collect(Collectors.toList());
    }

    public List<Flight> findFlightsToDestination(String destinationAirport) {
        return airports.getAirports().stream()
                .filter(airport -> airport.getDestinations().contains(destinationAirport))
                .map(airport -> new Flight(airport.getName(), destinationAirport))
                .toList();
    }

    public List<Flight> findFlightsWithConnection(String destinationAirport, String connectionAirport) {
        List<Flight> connectionAirports = findFlightsToDestination(destinationAirport);

        return connectionAirports.stream()
                .filter(flight -> flight.getDepartureAirport().equals(connectionAirport))
                .map(flight -> findFlightsToDestination(flight.getDepartureAirport()))
                .flatMap(List::stream)
                .map(departure -> new Flight(departure.getDepartureAirport(), destinationAirport, connectionAirport))
                .collect(Collectors.toList());
    }
}
