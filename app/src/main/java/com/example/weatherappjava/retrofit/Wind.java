package com.example.weatherappjava.retrofit;

import com.google.gson.annotations.SerializedName;

public class Wind {
    @SerializedName("speed")
    private String speed;

    public String getSpeed() {
        return speed;
    }
}
