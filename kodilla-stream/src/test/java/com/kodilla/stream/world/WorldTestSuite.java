package com.kodilla.stream.world;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        World world = new World();
        world.addContinent(new Continent("Azja"));
        world.addContinent(new Continent("Europa"));
        world.addContinent(new Continent("Australia"));
        world.addContinent(new Continent("Ameryka Północna"));
        world.addContinent(new Continent("Ameryka Południowa"));

        world.getContinentList().get(0).addCountry(new Country("Rosja", new BigDecimal("142122776")));
        world.getContinentList().get(0).addCountry(new Country("Chiny", new BigDecimal("1401585247")));
        world.getContinentList().get(0).addCountry(new Country("Indie", new BigDecimal("1359527236")));
        world.getContinentList().get(1).addCountry(new Country("Polska", new BigDecimal("38420687")));
        world.getContinentList().get(1).addCountry(new Country("Niemcy", new BigDecimal("80457737")));
        world.getContinentList().get(1).addCountry(new Country("Francja", new BigDecimal("67364357")));
        world.getContinentList().get(1).addCountry(new Country("Wielka Brytania", new BigDecimal("65105256")));
        world.getContinentList().get(2).addCountry(new Country("Australia", new BigDecimal("25766601")));
        world.getContinentList().get(3).addCountry(new Country("USA", new BigDecimal("329256465")));
        world.getContinentList().get(3).addCountry(new Country("Kanada", new BigDecimal("35881659")));
        world.getContinentList().get(4).addCountry(new Country("Brazylia", new BigDecimal("208846892")));
        world.getContinentList().get(4).addCountry(new Country("Argentyna", new BigDecimal("44694198")));

        //When
        BigDecimal result = world.getPeopleQuantity();

        //Then
        BigDecimal expectedResult = new BigDecimal("3799029111");
        assertEquals(expectedResult, result);

    }
}
