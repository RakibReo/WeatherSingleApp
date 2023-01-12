package com.example.weatherappbysura;

import static com.example.weatherappbysura.Constants.base_url;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofitC {

    public static Retrofit retrofit=null;

    public static Retrofit getRetrofit(){

        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }

        return  retrofit;
    }


}
