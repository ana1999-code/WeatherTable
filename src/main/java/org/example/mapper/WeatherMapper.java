package org.example.mapper;

import org.example.model.WeatherForecast;
import org.example.model.WeatherResponse;

public class WeatherMapper {
    public WeatherForecast fromWeatherResponseToWeatherForecast(WeatherResponse weatherResponse) {
        WeatherForecast weatherForecast = new WeatherForecast();
        weatherForecast.setCityName(weatherResponse.getLocation().getName());
        WeatherResponse.Day day = weatherResponse.getForecast().getForecastday().get(0).getDay();
        weatherForecast.setMinTemp(day.getMintemp_c());
        weatherForecast.setMaxTemp(day.getMaxtemp_c());
        weatherForecast.setHumidity(day.getAvghumidity());
        weatherForecast.setWindSpeed(day.getMaxwind_kph());
        weatherForecast.setWindDirection("ssv");
        return weatherForecast;
    }
}
