package com.kodilla.good.patterns.challenges.flights;

import java.util.LinkedList;
import java.util.List;

public class AirportsGenerator {
    private List<Airport> airports;

    public AirportsGenerator() {
        airports = new LinkedList<>();
        airports.add(new Airport("WROCLAW", List.of("GDANSK", "WARSZAWA", "LONDYN", "BERLIN", "BARCELONA")));
        airports.add(new Airport("WARSZAWA", List.of("LONDYN", "BERLIN", "BARCELONA")));
        airports.add(new Airport("KRAKOW", List.of("GDANSK", "WARSZAWA", "LONDYN")));
        airports.add(new Airport("LONDYN", List.of("GDANSK", "WARSZAWA", "LONDYN", "BERLIN", "BARCELONA", "WROCLAW")));
    }

    public List<Airport> getAirports() {
        return airports;
    }
}
