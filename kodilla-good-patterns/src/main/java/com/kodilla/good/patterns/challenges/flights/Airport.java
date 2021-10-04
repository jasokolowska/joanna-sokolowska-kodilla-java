package com.kodilla.good.patterns.challenges.flights;

import java.util.List;

public class Airport {
        private String name;
        private List<String> destinations;

        public Airport(String name, List<String> destinations) {
                this.name = name;
                this.destinations = destinations;
        }

        public String getName() {
                return name;
        }

        public List<String> getDestinations() {
                return destinations;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Airport airport = (Airport) o;

                return name.equals(airport.name);
        }

        @Override
        public int hashCode() {
                return name.hashCode();
        }
}
