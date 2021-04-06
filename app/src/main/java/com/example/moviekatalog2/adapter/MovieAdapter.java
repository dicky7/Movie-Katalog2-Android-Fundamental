package com.example.moviekatalog2.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.moviekatalog2.Movie;
import com.example.moviekatalog2.R;
import com.example.moviekatalog2.itemDetail;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private Context context;

    public MovieAdapter(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    private ArrayList<Movie> movies;


    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    private OnItemClickCallback onItemClickCallback;



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.namaM.setText(movies.get(position).getName());
        holder.descM.setText(movies.get(position).getDescription());
        holder.genreM.setText(movies.get(position).getGenre());
        final  Movie movie = movies.get(position);
        Glide.with(holder.itemView.getContext())
                .load(movie.getPhoto())
                .apply(new RequestOptions().override(200,300))
                .into(holder.img_poster);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(movies.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView namaM,descM,genreM;
        private ImageView img_poster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namaM = itemView.findViewById(R.id.txt_name);
            genreM= itemView.findViewById(R.id.txt_genre);
            descM = itemView.findViewById(R.id.txt_desc);
            img_poster = itemView.findViewById(R.id.img_photo);
        }
    }

    public interface OnItemClickCallback {
        void  onItemClicked(Movie movie);
    }
}
