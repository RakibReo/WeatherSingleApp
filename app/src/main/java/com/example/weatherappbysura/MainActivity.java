package com.example.weatherappbysura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.example.weatherappbysura.databinding.ActivityMainBinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
   ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MyWeatherDTO currentdto=MyRetrofitC.getRetrofit().create(MyWeatherDTO.class);
        Call<ResponseWeather> weatherCall=currentdto.getCurrentWeather();

    weatherCall.enqueue(new Callback<ResponseWeather>() {
        @Override
        public void onResponse(Call<ResponseWeather> call, Response<ResponseWeather> response) {
            if(response.isSuccessful()){
                long dt=System.currentTimeMillis();
                Date date=new Date();
                DateFormat dateFormat=new SimpleDateFormat("dd mm yy");
                Log.i("TAG","onResponse "+response.body().getName());
                Log.i("TAG","onResponse "+response.body().getMain().getTemp());
                Log.i("TAG","onResponse "+dateFormat.format(date));




            }
        }

        @Override
        public void onFailure(Call<ResponseWeather> call, Throwable t) {

            Log.i("TAG","onFailure"+t.getMessage().toString());

        }
    });


    }
}