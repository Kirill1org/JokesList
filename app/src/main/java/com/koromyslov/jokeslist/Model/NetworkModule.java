package com.koromyslov.jokeslist.Model;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkModule {

    private final String URL = "http://api.icndb.com/jokes/";

    private OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS);
    private OkHttpClient okHttpClient = httpClientBuilder.build();

    private Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(URL)
            .client(okHttpClient)
            .build();

    public JokesService jokesService = retrofit.create(JokesService.class);
}
