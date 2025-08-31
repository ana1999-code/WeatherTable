package org.example.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.example.util.TestUtil.FILE_PROPS;

class WeatherConfigTest {

    private WeatherConfig weatherConfig;

    @BeforeEach
    void setUp() throws IOException {
        weatherConfig = new WeatherConfig(FILE_PROPS);
    }

    @Test
    public void TestGetApiKey() {
        String expectedActualKey = "test_key";
        String actualApiKey = weatherConfig.getApiKey();

        Assertions.assertEquals(expectedActualKey, actualApiKey);
    }

    @Test
    public void TestGetApiUrl() {
        String expectedApiUrl = "http://test_api/";
        String actualApiUrl = weatherConfig.getApiUrl();

        Assertions.assertEquals(expectedApiUrl, actualApiUrl);
    }

}