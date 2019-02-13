package com.app4fun.myapplication.data.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FilmeResponse {

    @SerializedName("poster_path")
    @Expose
    private final String caminhoPoster;

    @SerializedName("backdrop_path")
    @Expose
    private final String posterDetalhe;

    @SerializedName("original_title")
    @Expose
    private final String tituloOriginal;

    @SerializedName("overview")
    @Expose
    private final String sinopse;

    public FilmeResponse(String caminhoPoster, String tituloOriginal, String sinopse, String posterDetalhe) {
        this.caminhoPoster = caminhoPoster;
        this.tituloOriginal = tituloOriginal;
        this.sinopse = sinopse;
        this.posterDetalhe = posterDetalhe;
    }

    public String getCaminhoPoster() {
        return caminhoPoster;
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }

    public String getSinopse() {
        return sinopse;
    }

    public String getPosterDetalhe() {
        return posterDetalhe;
    }
}
