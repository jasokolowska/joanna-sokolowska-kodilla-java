package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class World {
    private List<Continent> continentList;

    public World() {
        this.continentList = new ArrayList<>();
    }

    public BigDecimal getPeopleQuantity() {
        return continentList.stream()
                .flatMap(continent -> continent.getCountryList().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }

    public void addContinent(Continent continent) {
        continentList.add(continent);
    }
    public List<Continent> getContinentList() {
        return continentList;
    }
}
