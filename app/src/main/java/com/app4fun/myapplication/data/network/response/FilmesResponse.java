package com.app4fun.myapplication.data.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FilmesResponse {

    @SerializedName("poster_path")
    @Expose
    private final String caminhoPoster;


    @SerializedName("original_title")
    @Expose
    private final String tituloOriginal;

    public FilmesResponse(String caminhoPoster, String tituloOriginal) {
        this.caminhoPoster = caminhoPoster;
        this.tituloOriginal = tituloOriginal;
    }

    public String getCaminhoPoster() {
        return caminhoPoster;
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }
}
