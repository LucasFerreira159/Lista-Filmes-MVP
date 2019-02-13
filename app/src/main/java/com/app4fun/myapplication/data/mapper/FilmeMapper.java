package com.app4fun.myapplication.data.mapper;

import com.app4fun.myapplication.data.model.Filme;
import com.app4fun.myapplication.data.network.response.FilmeResponse;

import java.util.ArrayList;
import java.util.List;

public class FilmeMapper {

    public static List<Filme> deResponseParaDominio(List<FilmeResponse> response) {
        List<Filme> filmes = new ArrayList<>();

        for (FilmeResponse filmeResponse : response) {
            final Filme filme = new Filme(
                    filmeResponse.getTituloOriginal(),
                    filmeResponse.getCaminhoPoster());
            filmes.add(filme);
        }

        return filmes;
    }
}
