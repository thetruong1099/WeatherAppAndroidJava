package com.example.weatherappjava.retrofit;

import com.google.gson.annotations.SerializedName;

public class Main {
    @SerializedName("temp")
    private String temp;
    @SerializedName("temp_min")
    private String temp_min;
    @SerializedName("temp_max")
    private String temp_max;
    @SerializedName("pressure")
    private String pressure;
    @SerializedName("humidity")
    private String humidity;

    public String getTemp() {
        return temp;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getTemp_min() {
        return temp_min;
    }

    public String getTemp_max() {
        return temp_max;
    }

    public String getPressure() {
        return pressure;
    }
}
