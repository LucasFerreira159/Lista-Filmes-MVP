package com.app4fun.myapplication.ui.listaFilmes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.app4fun.myapplication.R;
import com.app4fun.myapplication.data.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class ListaFilmes extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;

    private List<Filme> filmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Filmes");
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.lista_filmes);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new ListaFilmesAdapter(this, filmes));

        criarFilmes();
    }

    public void criarFilmes(){
        Filme filme = new Filme("Teste");
        filmes.add(filme);

        filme = new Filme("Teste 2");
        filmes.add(filme);

        filme = new Filme("Teste 3");
        filmes.add(filme);

        filme = new Filme("Teste 4");
        filmes.add(filme);
    }
}
