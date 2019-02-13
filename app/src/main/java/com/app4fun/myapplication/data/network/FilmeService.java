package com.app4fun.myapplication.data.network;

import com.app4fun.myapplication.data.model.Filme;
import com.app4fun.myapplication.data.network.response.FilmesResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmeService {

    @GET("movie/popular")
    Call<FilmesResult> recuperarFilmes(@Query("api_key") String chaveAPI);
}
