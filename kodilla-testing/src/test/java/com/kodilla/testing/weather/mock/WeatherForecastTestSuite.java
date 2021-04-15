package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)     // musi być, żeby poniższy zapis działał.
class WeatherForecastTestSuite {

    @Mock                               // konieczna adnotacja żeby nie musieć pisać "=mock(Temperatures.class)"
    Temperatures temperaturesMock;// = mock(Temperatures.class);

    Map<String, Double> temperaturesMap = new HashMap<>();

    @BeforeEach
    void before() {
        temperaturesMap.put("Rzeszow", 40.00);
        temperaturesMap.put("Krakow", 50.00);
        temperaturesMap.put("Wroclaw", 10.00);
        temperaturesMap.put("Warszawa", 20.00);
        temperaturesMap.put("Gdansk", 30.00);

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
    void testCalculateAverageTemperatureWithMOck() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double expectedAverageTemperature = 30.00;
        double resultAverageTemperature = weatherForecast.calculateAverageTemperature();

        //Then
        Assertions.assertEquals(expectedAverageTemperature, resultAverageTemperature);
    }

    @Test
    void testCalculateMedianTemperatureWithMock_OddArraySize() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double expectedMedianTemperature = 30.00;
        double resultMedianTemperature = weatherForecast.calculateMedianTemperature();

        //Then
        Assertions.assertEquals(expectedMedianTemperature, resultMedianTemperature);
    }

    @Test
    void testCalculateMedianTemperatureWithMock_EvenArraySize() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        temperaturesMap.put("Olsztyn", 60.00);

        //When
        double expectedMedianTemperature = 35.00;
        double resultMedianTemperature = weatherForecast.calculateMedianTemperature();

        //Then
        Assertions.assertEquals(expectedMedianTemperature, resultMedianTemperature);
    }
}