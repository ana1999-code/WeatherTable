package org.example.service;

import org.example.model.WeatherResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI {
    @GET("forecast.json")
    Call<WeatherResponse> weather(@Query("key") String key,
                                  @Query("q") String city,
                                  @Query("dt") String date);
}
