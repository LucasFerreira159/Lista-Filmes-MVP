package com.app4fun.myapplication.ui.listaFilmes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app4fun.myapplication.R;
import com.app4fun.myapplication.data.model.Filme;
import com.app4fun.myapplication.data.network.response.FilmesResponse;

import java.util.List;
import java.util.zip.Inflater;

public class ListaFilmesAdapter extends RecyclerView.Adapter<ListaFilmesAdapter.MyViewHolder> {

    private Context context;
    private List<FilmesResponse> filmes;

    public ListaFilmesAdapter(Context context, List<FilmesResponse> filmes) {
        this.context = context;
        this.filmes = filmes;
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
        myViewHolder.titulo.setText(filmes.get(i).getTituloOriginal());
    }

    @Override
    public int getItemCount() {
        return filmes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.text_filme);
        }
    }
}
