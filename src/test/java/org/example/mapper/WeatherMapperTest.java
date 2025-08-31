package org.example.mapper;

import org.example.model.WeatherForecast;
import org.example.model.WeatherResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.util.TestUtil.getWeatherForecast;
import static org.example.util.TestUtil.getWeatherResponse;

class WeatherMapperTest {

    private WeatherMapper weatherMapper;

    @BeforeEach
    void setUp() {
        weatherMapper = new WeatherMapper();
    }

    @Test
    public void TestConvertFromWeatherResponseToWeatherForecast() {
        WeatherResponse weatherResponse = getWeatherResponse();
        WeatherForecast expectedWeatherForecast = getWeatherForecast();
        WeatherForecast actualWeatherForecast = weatherMapper.fromWeatherResponseToWeatherForecast(weatherResponse);

        Assertions.assertEquals(expectedWeatherForecast, actualWeatherForecast);
    }

}