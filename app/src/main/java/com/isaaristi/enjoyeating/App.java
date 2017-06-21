package com.isaaristi.enjoyeating;

import android.app.Application;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application{

    public static Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder().baseUrl("https://test-isabel-restaurante.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create(new Gson())).build();
    }
}
