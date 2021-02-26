package com.example.weatherappjava.retrofit;

import com.google.gson.annotations.SerializedName;

public class Example {
    @SerializedName("name")
    private String name;
    @SerializedName("dt")
    private int dt;
    @SerializedName("main")
    private Main main;
//    @SerializedName("weather")
//    private Weather weather;
    @SerializedName("sys")
    private Sys system;
    @SerializedName("wind")
    private Wind wind;


    public String getName() {return name;}
    public int getDt() {return dt;}
    public Main getMain() { return main;}
//    public Weather getWeather() { return weather;}
    public Sys getSystem() { return system;}
    public Wind getWind() { return wind;}
}
