package com.example.moviekatalog2.fragment;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.moviekatalog2.Movie;
import com.example.moviekatalog2.R;
import com.example.moviekatalog2.adapter.MovieAdapter;
import com.example.moviekatalog2.itemDetail;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    private String[] namaMovie;
    private String[] genreMovie;
    private String[] DescMovie;
    private String[] ratingMovie;
    private TypedArray MoviePoster;
    private MovieAdapter adapter;
    RecyclerView recyclerView;
    private ArrayList<Movie> movies = new ArrayList<>();

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        recyclerView = view.findViewById(R.id.rv_movie);
        recyclerView.setHasFixedSize(true);
        prepare();
        addItem();
        showRecylerList();
        return view;
    }

    private void showRecylerList(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        MovieAdapter movieAdapter = new MovieAdapter(movies);
        recyclerView.setAdapter(movieAdapter);

        movieAdapter.setOnItemClickCallback(new MovieAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Movie movie) {
                Intent intent = new Intent(getContext(), itemDetail.class);
                intent.putExtra(itemDetail.EXTRA_MOVIE,movie);
                startActivity(intent);
            }
        });

    }


    private void prepare() {
        namaMovie = getResources().getStringArray(R.array.data_nama_movie);
        genreMovie = getResources().getStringArray(R.array.data_genre_movie);
        ratingMovie = getResources().getStringArray(R.array.data_ratig_movie);
        DescMovie = getResources().getStringArray(R.array.data_desc_movie);
        MoviePoster = getResources().obtainTypedArray(R.array.data_photo_movie);
    }

    private void addItem() {
        movies = new ArrayList<>();

        for (int i = 0; i < namaMovie.length; i++) {
            Movie movie = new Movie();
            movie.setPhoto(MoviePoster.getResourceId(i,1));
            movie.setName(namaMovie[i]);
            movie.setGenre(genreMovie[i]);
            movie.setRating(ratingMovie[i]);
            movie.setDescription(DescMovie[i]);
            movies.add(movie);

        }
    }
}
