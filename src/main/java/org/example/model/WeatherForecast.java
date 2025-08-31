package org.example.model;

import java.util.Objects;

public class WeatherForecast {
    private String cityName;
    private Double minTemp;
    private Double maxTemp;
    private Double humidity;
    private Double windSpeed;
    private String windDirection;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Double minTemp) {
        this.minTemp = minTemp;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        WeatherForecast that = (WeatherForecast) o;
        return Objects.equals(cityName, that.cityName)
                && Objects.equals(minTemp, that.minTemp)
                && Objects.equals(maxTemp, that.maxTemp)
                && Objects.equals(humidity, that.humidity)
                && Objects.equals(windSpeed, that.windSpeed)
                && Objects.equals(windDirection, that.windDirection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityName, minTemp, maxTemp, humidity, windSpeed, windDirection);
    }
}
