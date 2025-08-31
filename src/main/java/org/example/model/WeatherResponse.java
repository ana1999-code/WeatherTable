package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class WeatherResponse {
    private Location location;
    private Forecast forecast;

    public Location getLocation() {
        return location;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    public static class Location {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Forecast {
        private final List<ForecastDay> forecastday = new ArrayList<>();

        public List<ForecastDay> getForecastday() {
            return forecastday;
        }
    }

    public static class ForecastDay {
        private Day day;
        private final List<Hour> hour = new ArrayList<>();

        public Day getDay() {
            return day;
        }

        public List<Hour> getHour() {
            return hour;
        }

        public void setDay(Day day) {
            this.day = day;
        }
    }

    public static class Day {
        private Double maxtemp_c;
        private Double mintemp_c;
        private Double avghumidity;
        private Double maxwind_kph;

        public Double getMaxtemp_c() {
            return maxtemp_c;
        }

        public Double getMintemp_c() {
            return mintemp_c;
        }

        public Double getAvghumidity() {
            return avghumidity;
        }

        public Double getMaxwind_kph() {
            return maxwind_kph;
        }

        public void setMaxtemp_c(Double maxtemp_c) {
            this.maxtemp_c = maxtemp_c;
        }

        public void setMintemp_c(Double mintemp_c) {
            this.mintemp_c = mintemp_c;
        }

        public void setAvghumidity(Double avghumidity) {
            this.avghumidity = avghumidity;
        }

        public void setMaxwind_kph(Double maxwind_kph) {
            this.maxwind_kph = maxwind_kph;
        }
    }

    public static class Hour {
        private String wind_dir;

        public String getWind_dir() {
            return wind_dir;
        }

        public void setWind_dir(String wind_dir) {
            this.wind_dir = wind_dir;
        }
    }
}
