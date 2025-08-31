package org.example.service;

import org.example.config.WeatherConfig;
import org.example.exception.WeatherException;
import org.example.mapper.WeatherMapper;
import org.example.model.WeatherForecast;
import org.example.model.WeatherResponse;
import org.example.util.DateUtil;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Optional;

public class WeatherService {
    private final WeatherMapper weatherMapper;
    private final WeatherConfig weatherConfig;
    private final WeatherAPI weatherAPI;

    public WeatherService(WeatherConfig weatherConfig, WeatherMapper weatherMapper, WeatherAPI weatherAPI) {
        this.weatherConfig = weatherConfig;
        this.weatherMapper = weatherMapper;
        this.weatherAPI = weatherAPI;
    }

    public WeatherService(WeatherConfig weatherConfig, WeatherMapper weatherMapper) {
        this.weatherConfig = weatherConfig;
        this.weatherMapper = weatherMapper;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(weatherConfig.getApiUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.weatherAPI = retrofit.create(WeatherAPI.class);
    }

    public WeatherForecast getNextDayWeather(String city) throws IOException, WeatherException {
        Call<WeatherResponse> call = weatherAPI.weather(weatherConfig.getApiKey(),
                city, DateUtil.nextDay());

        Optional<WeatherResponse> weatherResponse = Optional.ofNullable(call.execute().body());

        return weatherMapper
                .fromWeatherResponseToWeatherForecast(
                        weatherResponse.orElseThrow(() -> new WeatherException("Weather exception"))
                );
    }
}

