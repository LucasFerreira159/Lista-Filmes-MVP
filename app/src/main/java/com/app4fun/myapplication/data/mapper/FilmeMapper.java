package com.app4fun.myapplication.data.mapper;

import com.app4fun.myapplication.data.model.Filme;
import com.app4fun.myapplication.data.network.response.FilmesResponse;

import java.util.ArrayList;
import java.util.List;

public class FilmeMapper {

    public static List<Filme> deResponseParaDominio(List<FilmesResponse> response){
        List<Filme> filmes = new ArrayList<>();

        for(FilmesResponse filmesResponse : response){
            final Filme filme = new Filme(filmesResponse.getTituloOriginal());
            filmes.add(filme);
        }

        return filmes;
    }
}
