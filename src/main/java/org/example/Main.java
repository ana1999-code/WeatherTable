package org.example;

import org.example.config.WeatherConfig;
import org.example.exception.WeatherException;
import org.example.mapper.WeatherMapper;
import org.example.model.WeatherForecast;
import org.example.service.WeatherService;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, WeatherException {
        WeatherMapper weatherMapper = new WeatherMapper();
        WeatherConfig weatherConfig = new WeatherConfig();
        WeatherService weatherService = new WeatherService(weatherConfig, weatherMapper);
        WeatherForecast weatherForecast = weatherService.getNextDayWeather("London");
        System.out.println(weatherForecast);
    }
}