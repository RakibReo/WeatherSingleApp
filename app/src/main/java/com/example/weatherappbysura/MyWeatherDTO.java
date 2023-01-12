package com.example.weatherappbysura;

import static com.example.weatherappbysura.Constants.weather_api_key;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyWeatherDTO {

    @GET("weather?q=Dhaka&appid="+weather_api_key)
    Call<ResponseWeather> getCurrentWeather();
}
