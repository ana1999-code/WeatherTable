package org.example.util;

import okhttp3.Request;
import okio.Timeout;
import org.example.model.WeatherForecast;
import org.example.model.WeatherResponse;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

public class TestUtil {
    public final static String FILE_PROPS = "src/test/resources/application.properties";
    public final static Call<WeatherResponse> RESPONSE_CALL = new Call<>() {
        @Override
        public Response<WeatherResponse> execute() throws IOException {
            return Response.success(getWeatherResponse());
        }

        @Override
        public void enqueue(Callback<WeatherResponse> callback) {

        }

        @Override
        public boolean isExecuted() {
            return false;
        }

        @Override
        public void cancel() {

        }

        @Override
        public boolean isCanceled() {
            return false;
        }

        @Override
        public Call<WeatherResponse> clone() {
            return null;
        }

        @Override
        public Request request() {
            return null;
        }

        @Override
        public Timeout timeout() {
            return null;
        }
    };

    public final static Call<WeatherResponse> NULL_RESPONSE_CALL = new Call<>() {
        @Override
        public Response<WeatherResponse> execute() throws IOException {
            return Response.success(null);
        }

        @Override
        public void enqueue(Callback<WeatherResponse> callback) {

        }

        @Override
        public boolean isExecuted() {
            return false;
        }

        @Override
        public void cancel() {

        }

        @Override
        public boolean isCanceled() {
            return false;
        }

        @Override
        public Call<WeatherResponse> clone() {
            return null;
        }

        @Override
        public Request request() {
            return null;
        }

        @Override
        public Timeout timeout() {
            return null;
        }
    };

    public static final String CITY_NAME = "test";
    public static final Double MIN_TEMP = 10.0;
    public static final Double MAX_TEMP = 20.0;
    public static final Double HUMIDITY = 70.0;
    public static final Double WIND_SPEED = 20.0;
    public static final String WIND_DIR = "SV";

    @NotNull
    public static WeatherResponse getWeatherResponse() {
        WeatherResponse weatherResponse = new WeatherResponse();
        weatherResponse.setLocation(new WeatherResponse.Location());
        weatherResponse.getLocation().setName(CITY_NAME);
        weatherResponse.setForecast(new WeatherResponse.Forecast());
        weatherResponse.getForecast().getForecastday().add(new WeatherResponse.ForecastDay());
        weatherResponse.getForecast().getForecastday().get(0).setDay(new WeatherResponse.Day());
        WeatherResponse.Day day = weatherResponse.getForecast().getForecastday().get(0).getDay();
        day.setMintemp_c(MIN_TEMP);
        day.setMaxtemp_c(MAX_TEMP);
        day.setAvghumidity(HUMIDITY);
        day.setMaxwind_kph(WIND_SPEED);
        weatherResponse.getForecast().getForecastday().get(0).getHour().add(new WeatherResponse.Hour());
        weatherResponse.getForecast().getForecastday().get(0).getHour().get(0).setWind_dir(WIND_DIR);
        return weatherResponse;
    }

    @NotNull
    public static WeatherForecast getWeatherForecast() {
        WeatherForecast weatherForecast = new WeatherForecast();
        weatherForecast.setCityName(CITY_NAME);
        weatherForecast.setMinTemp(MIN_TEMP);
        weatherForecast.setMaxTemp(MAX_TEMP);
        weatherForecast.setHumidity(HUMIDITY);
        weatherForecast.setWindSpeed(WIND_SPEED);
        weatherForecast.setWindDirection(WIND_DIR);
        return weatherForecast;
    }
}
