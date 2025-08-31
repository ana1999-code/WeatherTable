package org.example.service;

import org.example.config.WeatherConfig;
import org.example.exception.WeatherException;
import org.example.mapper.WeatherMapper;
import org.example.model.WeatherForecast;
import org.example.model.WeatherResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.example.util.TestUtil.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WeatherServiceTest {

    private WeatherMapper weatherMapper;
    private WeatherConfig weatherConfig;
    private WeatherAPI weatherAPI;
    private WeatherService weatherService;

    @BeforeEach
    void setUp() throws IOException {
        weatherAPI = mock(WeatherAPI.class);
        weatherConfig = mock(WeatherConfig.class);
        weatherMapper = mock(WeatherMapper.class);
        weatherService = new WeatherService(weatherConfig, weatherMapper, weatherAPI);
    }

    @Test
    public void TestGetNextDayWeather() throws IOException, WeatherException {
        WeatherForecast expectedNextDayWeather = getWeatherForecast();
        
        when(weatherConfig.getApiKey()).thenReturn("test_key");
        when(weatherAPI.weather(any(), anyString(), anyString()))
                .thenReturn(RESPONSE_CALL);
        when(weatherMapper.fromWeatherResponseToWeatherForecast(any(WeatherResponse.class)))
                .thenReturn(expectedNextDayWeather);

        WeatherForecast actualNextDayWeather = weatherService.getNextDayWeather(CITY_NAME);
        Assertions.assertEquals(expectedNextDayWeather, actualNextDayWeather);
    }

    @Test
    public void TestGetNextDayWeatherWhenThrow() throws IOException, WeatherException {
        when(weatherConfig.getApiKey()).thenReturn("test_key");
        when(weatherAPI.weather(any(), anyString(), anyString()))
                .thenReturn(NULL_RESPONSE_CALL);

        Assertions.assertThrows(WeatherException.class, () -> weatherService.getNextDayWeather(CITY_NAME)
                , "Invalid weather");
    }

    @Test
    public void TestGetNextDayWeatherWhenThrowInvalidKey() throws IOException, WeatherException {
        when(weatherConfig.getApiKey()).thenReturn("default_key");

        Assertions.assertThrows(WeatherException.class, () -> weatherService.getNextDayWeather(CITY_NAME)
                , "Api key not valid");
    }
}