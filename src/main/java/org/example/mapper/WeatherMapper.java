package org.example.mapper;

import org.example.model.WeatherForecast;
import org.example.model.WeatherResponse;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WeatherMapper {
    public WeatherForecast fromWeatherResponseToWeatherForecast(WeatherResponse weatherResponse) {
        WeatherForecast weatherForecast = new WeatherForecast();
        weatherForecast.setCityName(weatherResponse.getLocation().getName());

        WeatherResponse.Day day = weatherResponse.getForecast().getForecastday().get(0).getDay();
        weatherForecast.setMinTemp(day.getMintemp_c());
        weatherForecast.setMaxTemp(day.getMaxtemp_c());
        weatherForecast.setHumidity(day.getAvghumidity());
        weatherForecast.setWindSpeed(day.getMaxwind_kph());

        List<WeatherResponse.Hour> hours = weatherResponse.getForecast().getForecastday().get(0).getHour();
        Set<String> windDirections = new HashSet<>();
        hours.forEach(hour -> windDirections.add(hour.getWind_dir()));
        weatherForecast.setWindDirection(String.join(", ", windDirections));

        return weatherForecast;
    }
}
