package com.app4fun.myapplication.ui.listaFilmes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.app4fun.myapplication.R;
import com.app4fun.myapplication.data.model.Filme;
import com.app4fun.myapplication.data.network.ApiService;
import com.app4fun.myapplication.data.network.response.FilmesResult;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmes extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;

    private List<Filme> filmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);

        recyclerView = findViewById(R.id.lista_filmes);
        toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle("Filmes");
        setSupportActionBar(toolbar);

        ApiService.getInstance().recuperarFilmes(getString(R.string.chave_api_the_movies_db))
                .enqueue(new Callback<FilmesResult>() {
                    @Override
                    public void onResponse(Call<FilmesResult> call, Response<FilmesResult> response) {
                        if (response.isSuccessful()) {
                            response.body().getRestultadoFilmes().get(0);
                            RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                            recyclerView.setLayoutManager(linearLayoutManager);
                            recyclerView.setHasFixedSize(true);
                            recyclerView.setAdapter(new ListaFilmesAdapter(getApplicationContext(), response.body().getRestultadoFilmes()));
                        }
                    }

                    @Override
                    public void onFailure(Call<FilmesResult> call, Throwable t) {

                    }
                });
    }
}
