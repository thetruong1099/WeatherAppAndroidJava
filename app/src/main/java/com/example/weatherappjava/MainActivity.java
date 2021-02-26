package com.example.weatherappjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.weatherappjava.retrofit.ApiClient;
import com.example.weatherappjava.retrofit.ApiInterface;
import com.example.weatherappjava.retrofit.Example;
import com.google.gson.internal.bind.util.ISO8601Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView temp,humidity,temp_min,temp_max,pressure,sunrise,sunset,wind,status,address,update_at;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temp = findViewById(R.id.temp);
        temp_min = findViewById(R.id.temp_min);
        temp_max = findViewById(R.id.temp_max);
        pressure = findViewById(R.id.pressure);
        humidity = findViewById(R.id.humidity);
        sunrise =findViewById(R.id.sunrise);
        sunset = findViewById(R.id.sunset);
        wind = findViewById(R.id.wind);
        status =findViewById(R.id.status);
        address = findViewById(R.id.address);
        update_at = findViewById(R.id.update_at);

        getWeather();
    }

    private void getWeather() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Example> call = apiInterface.getWeatherData();
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                address.setText(response.body().getName()+", "+response.body().getSystem().getCountry());
                update_at.setText("Update at: "+new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(new Date(response.body().getDt()*1000)));

//                status.setText(response.body().getWeather().getDescription());

                temp.setText(response.body().getMain().getTemp()+"°C");
                temp_min.setText("Min temp: "+ response.body().getMain().getTemp_min()+"°C");
                temp_max.setText("Max temp: "+ response.body().getMain().getTemp_max()+"°C");
                pressure.setText(response.body().getMain().getPressure());
                humidity.setText(response.body().getMain().getHumidity());
                sunrise.setText(new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date(response.body().getSystem().getSunrise()*1000)));
                sunset.setText(new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date(response.body().getSystem().getSunset()*1000)));
                wind.setText(response.body().getWind().getSpeed());
                System.out.println();
            }
            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                System.out.println("null");
            }
        });
    }
}