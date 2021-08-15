package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public double calculateAverageTemperature() {
        double sum = 0;
        for (Map.Entry<String, Double> temperature:
                temperatures.getTemperatures().entrySet()) {
            sum += temperature.getValue();
        }
        return sum/(temperatures.getTemperatures().size());
    }

    public double calculateMedianTemperatures(){
        List<Double> temperatureList = mapToListAndSort();

        int middleIndex = (int)Math.floor(temperatureList.size()/2);
        return temperatureList.get(middleIndex);
    }

    public List<Double> mapToListAndSort () {
        List<Double> temperatureList = new ArrayList<>();

        for (Map.Entry<String, Double> temperature:
                temperatures.getTemperatures().entrySet()) {
            temperatureList.add(temperature.getValue());
        }
        temperatureList.sort(Comparator.naturalOrder());
        return temperatureList;
    }
}

