package com.app4fun.myapplication.data.network;

import com.app4fun.myapplication.data.model.Filme;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    public static FilmeService INSTANCE;

    public static FilmeService getInstance() {
        if (INSTANCE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            INSTANCE = retrofit.create(
                    FilmeService.class);
        }

        return INSTANCE;
    }
}
