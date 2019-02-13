package com.app4fun.myapplication.ui.listaFilmes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app4fun.myapplication.R;
import com.app4fun.myapplication.data.model.Filme;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListaFilmesAdapter extends RecyclerView.Adapter<ListaFilmesAdapter.MyViewHolder> {


    private List<Filme> filmes;

    public ListaFilmesAdapter() {
        filmes = new ArrayList<>();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_lista_filmes, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.bind(filmes.get(i));
    }

    @Override
    public int getItemCount() {
        return filmes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        ImageView capa;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            capa = itemView.findViewById(R.id.capa_filme);
            titulo = itemView.findViewById(R.id.text_filme);
        }

        public void bind(Filme filme){
            titulo.setText(filme.getTitulo());
            Picasso.get().load("https://image.tmdb.org/t/p/w500/" + filme.getCapaFilme()).into(capa);
        }
    }

    public void setFilmes(List<Filme> filmes){
        this.filmes = filmes;
        notifyDataSetChanged();
    }

}
