package com.kodilla.exception.test;

import java.util.ArrayList;
import java.util.List;

public class FlightRunner {

    public static void main(String[] args) {
        FlightSearch flightSearch = new FlightSearch();

        List<Flight> flightList = new ArrayList<>();
        flightList.add(new Flight("Wroclaw", "Istambul"));
        flightList.add(new Flight("Wroclaw", "Warsaw"));
        flightList.add(new Flight("Wroclaw", "New York"));

        for (Flight flight : flightList) {
            try {
                flightSearch.findFlight(flight);
            } catch (RouteNotFoundException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Search ended");
        }

    }
}
