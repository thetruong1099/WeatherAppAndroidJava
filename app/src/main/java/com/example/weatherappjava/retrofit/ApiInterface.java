package com.example.weatherappjava.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("weather?q=Hanoi&units=metric&appid=5339f552ef5355d8b01ebe4149c5e8b9")
    Call<Example> getWeatherData();
}
