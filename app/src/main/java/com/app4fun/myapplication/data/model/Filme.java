package com.app4fun.myapplication.data.model;

public class Filme {

    private String titulo;
    private String capaFilme;

    public Filme(String nome, String capaFilme) {
        this.titulo = nome;
        this.capaFilme = capaFilme;
    }

    public String getCapaFilme() {
        return capaFilme;
    }

    public String getTitulo() {
        return titulo;
    }

}
