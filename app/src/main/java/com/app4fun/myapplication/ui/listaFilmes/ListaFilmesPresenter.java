package com.app4fun.myapplication.ui.listaFilmes;

import com.app4fun.myapplication.R;
import com.app4fun.myapplication.data.mapper.FilmeMapper;
import com.app4fun.myapplication.data.model.Filme;
import com.app4fun.myapplication.data.network.ApiService;
import com.app4fun.myapplication.data.network.response.FilmesResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesPresenter
        implements ListaFilmesContrato.ListaFilmePresenter {

    private ListaFilmesContrato.ListaFilmeView view;

    public ListaFilmesPresenter(ListaFilmesContrato.ListaFilmeView view) {
        this.view = view;
    }

    @Override
    public void obtemFilmes() {
        ApiService.getInstance().recuperarFilmes("3c6b7b5163f500336234a349b8b17a74")
                .enqueue(new Callback<FilmesResult>() {
                    @Override
                    public void onResponse(Call<FilmesResult> call, Response<FilmesResult> response) {
                        if (response.isSuccessful()) {
                            final List<Filme> filmes = FilmeMapper
                                    .deResponseParaDominio(response.body().getRestultadoFilmes());
                            view.mostraFilmes(filmes);
                        }else{
                            view.mostraErro();
                        }
                    }

                    @Override
                    public void onFailure(Call<FilmesResult> call, Throwable t) {
                        view.mostraErro();
                    }
                });
    }

    @Override
    public void destroirView() {
        this.view = null;
    }
}
