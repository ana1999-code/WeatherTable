package org.example;

import org.example.config.WeatherConfig;
import org.example.exception.WeatherException;
import org.example.mapper.WeatherMapper;
import org.example.model.WeatherForecast;
import org.example.printer.Printer;
import org.example.printer.TablePrinter;
import org.example.service.WeatherService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private final static String FILE_PROPS = "src/main/resources/application.properties";

    public static void main(String[] args) throws IOException, WeatherException {
        WeatherMapper weatherMapper = new WeatherMapper();
        WeatherConfig weatherConfig = new WeatherConfig(FILE_PROPS);
        WeatherService weatherService = new WeatherService(weatherConfig, weatherMapper);

        List<String> cities = List.of("Chisinau", "Madrid", "Kyiv", "Amsterdam");

        List<WeatherForecast> weatherForecastList = new ArrayList<>();
        for (String city : cities) {
            weatherForecastList.add(weatherService.getNextDayWeather(city));
        }

        Map<String, List<String>> tableData = new LinkedHashMap<>();
        for (WeatherForecast forecast : weatherForecastList) {
            tableData.put(forecast.getCityName(), List.of(
                    forecast.getMinTemp().toString(),
                    forecast.getMaxTemp().toString(),
                    forecast.getHumidity().toString(),
                    forecast.getWindSpeed().toString(),
                    forecast.getWindDirection()
            ));
        }

        List<String> columns = List.of(
                "City", "Min temp (°C)", "Max temp (°C)", "Humidity (%)", "Wind Speed (kph)", "Wind Direction"
        );

        Printer<Map<String, List<String>>> printer = new TablePrinter<>(columns);
        printer.print(tableData);
    }
}