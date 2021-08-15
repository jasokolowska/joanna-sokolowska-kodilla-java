package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherForecastTestSuite {

    @Mock
    private Temperatures temperaturesMock;

    @BeforeEach
    public void prepareTemperaturesMap() {
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
    }

    @Test
    void testCalculateForecastWithMock() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @Test
    void testCalculateAverageTemp(){
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        double currentAverageTemp = 25.56;

        //When
        double result = weatherForecast.calculateAverageTemperature();

        //Then
        Assertions.assertEquals(currentAverageTemp, result);

    }

    @Test
    void testCalculateMedianTemp(){
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        double currentMedianTemp = 25.5;

        //When
        double result = weatherForecast.calculateMedianTemperatures();

        //Then
        Assertions.assertEquals(currentMedianTemp, result);

    }

    @Test
    void testSortingArray() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        List<Double> sortedArray = new ArrayList<>();
        Collections.addAll(sortedArray, 24.8, 25.2, 25.5, 26.1, 26.2);

        //When
        List<Double> result = weatherForecast.mapToListAndSort();

        //Then
        Assertions.assertEquals(sortedArray, result);
    }
}
