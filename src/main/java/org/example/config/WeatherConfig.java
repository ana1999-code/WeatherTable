package org.example.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WeatherConfig {
    private String apiKey;
    private String apiUrl;

    public WeatherConfig() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("src/main/resources/application.properties"));

        this.apiKey = props.getProperty("weather.api.key");
        this.apiUrl = props.getProperty("weather.api.url");
    }

    public String getApiKey() {
        String envApiKey = System.getenv("API_KEY");
        if (envApiKey != null) {
            return envApiKey;
        }
        return apiKey;
    }

    public String getApiUrl() {
        return apiUrl;
    }
}
