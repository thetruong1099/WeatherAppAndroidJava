package com.example.weatherappjava.retrofit;

import com.google.gson.annotations.SerializedName;

public class Sys {
    @SerializedName("sunrise")
    private int sunrise;
    @SerializedName("sunset")
    private int sunset;
    @SerializedName("country")
    private String country;

    public int getSunrise() {
        return sunrise;
    }

    public int getSunset() {
        return sunset;
    }

    public String getCountry() {
        return country;
    }
}
