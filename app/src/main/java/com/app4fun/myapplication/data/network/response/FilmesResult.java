package com.app4fun.myapplication.data.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FilmesResult {

    @SerializedName("results")
    @Expose
    private final List<FilmeResponse> restultadoFilmes;

    public FilmesResult(List<FilmeResponse> restultadoFilmes) {
        this.restultadoFilmes = restultadoFilmes;
    }

    public List<FilmeResponse> getRestultadoFilmes() {
        return restultadoFilmes;
    }
}
