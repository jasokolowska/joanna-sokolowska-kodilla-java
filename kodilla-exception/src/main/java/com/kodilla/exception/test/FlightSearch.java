package com.kodilla.exception.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FlightSearch {

    public void findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean>  availableArrival = new HashMap<>();
        availableArrival.put("London", true);
        availableArrival.put("Warsaw", true);
        availableArrival.put("Paris", true);
        availableArrival.put("New York", false);
        availableArrival.put("Barcelona", true);

//        1. sposob
//        if (availableArrival.containsKey(flight.getArrivalAirport())) {
//            if (availableArrival.get(flight.getArrivalAirport())) {
//                System.out.println("Airport " + flight.getArrivalAirport() + " is available to fly");
//            } else {
//                throw new RouteNotFoundException(flight.getArrivalAirport() + " - arrival in this airport is unavailable");
//            }
//        } else {
//            throw new RouteNotFoundException(flight.getArrivalAirport() + " - Route not found.");
//        }

//      2. sposob
        boolean isRouteExist = availableArrival.entrySet().stream()
                .filter(entry -> entry.getValue() == true)
                .anyMatch(entry -> entry.getKey() == flight.getArrivalAirport());

        if (isRouteExist) {
            System.out.println("Airport " + flight.getArrivalAirport() + " is available to fly");
        } else {
            throw new RouteNotFoundException(flight.getArrivalAirport() + " - Route not found.");
        }
    }
}
