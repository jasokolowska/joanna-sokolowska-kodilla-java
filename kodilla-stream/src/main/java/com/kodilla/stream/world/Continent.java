package com.kodilla.stream.world;

import java.util.*;

public final class Continent {
    private final String name;
    private final List<Country> countryList;

    public Continent(String name) {
        this.name = name;
        this.countryList = new ArrayList<>();
    }

    public void addCountry (Country country) {
        countryList.add(country);
    }

    public String getName() {
        return name;
    }

    public List<Country> getCountryList() {
        return countryList;
    }
}
