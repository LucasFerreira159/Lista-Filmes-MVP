package com.app4fun.myapplication.data.model;

public class Filme {

    private String titulo;
    private String capaFilme;
    private String sinopse;
    private String capaDetalhe;

    public Filme(String titulo, String capaFilme, String sinopse, String capaDetalhe) {
        this.titulo = titulo;
        this.capaFilme = capaFilme;
        this.sinopse = sinopse;
        this.capaDetalhe = capaDetalhe;
    }

    public String getCapaFilme() {
        return capaFilme;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public String getCapaDetalhe() {
        return capaDetalhe;
    }
}
