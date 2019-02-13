package com.app4fun.myapplication.ui.listaFilmes;

import com.app4fun.myapplication.data.model.Filme;

import java.util.List;

public interface ListaFilmesContrato {

    interface ListaFilmeView {
        void mostraFilmes(List<Filme> filmes);

        void mostraErro();
    }

    interface ListaFilmePresenter {
        void obtemFilmes();

        void destroirView();
    }
}
