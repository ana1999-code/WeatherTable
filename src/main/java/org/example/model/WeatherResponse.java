package org.example.model;

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

    public static class Location {
        private String name;

        public String getName() {
            return name;
        }
    }

    public static class Forecast {
        private List<ForecastDay> forecastday;

        public List<ForecastDay> getForecastday() {
            return forecastday;
        }
    }

    public static class ForecastDay {
        private Day day;

        public Day getDay() {
            return day;
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
    }
}
