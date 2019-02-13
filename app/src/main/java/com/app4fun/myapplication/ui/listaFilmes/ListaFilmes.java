package com.app4fun.myapplication.ui.listaFilmes;

import android.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.app4fun.myapplication.R;
import com.app4fun.myapplication.data.mapper.FilmeMapper;
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

    private ListaFilmesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);

        configuraToolbar();
        configuraAdapter();
        obtemFilmes();
    }

    public void configuraToolbar() {
        toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle("Filmes");
        setSupportActionBar(toolbar);
    }

    public void configuraAdapter(){
        adapter = new ListaFilmesAdapter();

        recyclerView = findViewById(R.id.lista_filmes);
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    public void obtemFilmes(){
        ApiService.getInstance().recuperarFilmes(getString(R.string.chave_api_the_movies_db))
                .enqueue(new Callback<FilmesResult>() {
                    @Override
                    public void onResponse(Call<FilmesResult> call, Response<FilmesResult> response) {
                        if (response.isSuccessful()) {
                            final List<Filme> filmes = FilmeMapper
                                    .deResponseParaDominio(response.body().getRestultadoFilmes());
                            adapter.setFilmes(filmes);
                        }else{
                            mostraErro();
                        }
                    }

                    @Override
                    public void onFailure(Call<FilmesResult> call, Throwable t) {
                        mostraErro();
                    }
                });
    }

    public void mostraErro(){
        Toast.makeText(this, "Erro ao obter Dados", Toast.LENGTH_SHORT).show();
    }
}
