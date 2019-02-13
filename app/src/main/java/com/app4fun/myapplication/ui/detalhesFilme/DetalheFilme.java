package com.app4fun.myapplication.ui.detalhesFilme;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app4fun.myapplication.R;
import com.app4fun.myapplication.data.model.Filme;
import com.squareup.picasso.Picasso;
import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class DetalheFilme extends AppCompatActivity {

    private ImageView capaPrincipal;
    private ImageView capaDetalhe;
    private TextView titulo;
    private TextView sinopse;

    private Filme filme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_filme);

        recuperaWidgets();

        recuperaInformacoes();

        configuraToolbar();

        //Se estiver com versao acima ou igual Oreo ira justificar o texto com novo recurso TextView
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            sinopse.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
        }

    }

    public void configuraToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(filme.getTitulo());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void recuperaInformacoes(){
        filme = (Filme) getIntent().getSerializableExtra("filme");

        if(filme != null){
            Picasso.get().load("https://image.tmdb.org/t/p/w500/" + filme.getCapaDetalhe()).into(capaDetalhe);
            Picasso.get().load("https://image.tmdb.org/t/p/w500/" + filme.getCapaFilme()).into(capaPrincipal);
            sinopse.setText(filme.getSinopse());
            titulo.setText(filme.getTitulo());
        }
    }

    public void recuperaWidgets(){
        capaDetalhe = findViewById(R.id.capa_detalhe);
        capaPrincipal = findViewById(R.id.capa_principal);
        titulo = findViewById(R.id.text_titulo_detalhe);
        sinopse = findViewById(R.id.text_sinopse);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        finish();
        return true;
    }

}
