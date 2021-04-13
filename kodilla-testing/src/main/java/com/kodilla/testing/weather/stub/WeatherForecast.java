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
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateAverageTemperature() {
        double sumOfTemperatures = 0;
        double averageTemperature = 0;
        for (Map.Entry<String, Double> entry : temperatures.getTemperatures().entrySet()) {
            sumOfTemperatures += entry.getValue();
        }
        return averageTemperature = (sumOfTemperatures / temperatures.getTemperatures().size());
    }

    public double calculateMedianTemperature() {
        ArrayList<Double> temperaturesList = new ArrayList();

        for (Map.Entry<String, Double> entry : temperatures.getTemperatures().entrySet()) {
            temperaturesList.add(entry.getValue());
        }

        SortedSet<Double> sortedSet = new TreeSet<>();
        sortedSet.addAll(temperaturesList);

        temperaturesList.clear();
        temperaturesList.addAll(sortedSet);

        double median;

        if (temperaturesList.size() % 2 == 0) {
            Double firstElement = temperaturesList.get((temperaturesList.size() / 2) - 1);
            Double secondElement = temperaturesList.get(temperaturesList.size() / 2);

            median = (firstElement + secondElement) / 2;

        } else {
            median = temperaturesList.get((temperaturesList.size() / 2));
        }

        return median;
    }


}
