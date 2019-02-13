package com.app4fun.myapplication.data.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FilmesResult {

    @SerializedName("results")
    @Expose
    private final List<FilmesResponse> restultadoFilmes;

    public FilmesResult(List<FilmesResponse> restultadoFilmes) {
        this.restultadoFilmes = restultadoFilmes;
    }

    public List<FilmesResponse> getRestultadoFilmes() {
        return restultadoFilmes;
    }
}
