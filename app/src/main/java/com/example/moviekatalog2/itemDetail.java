package com.example.moviekatalog2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.Objects;

public class itemDetail extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    private TextView namaM, GenreM, RatingM, DescM;
    private ImageView posterM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        namaM = findViewById(R.id.item_nama_movie);
        GenreM = findViewById(R.id.item_nama_genre);
        RatingM = findViewById(R.id.item_rating);
        DescM = findViewById(R.id.item_deskirpsi);
        posterM = findViewById(R.id.item_poster);
        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);


        assert movie != null;
        namaM.setText(movie.getName());
        GenreM.setText(movie.getGenre());
        RatingM.setText(movie.getRating());
        DescM.setText(movie.getDescription());
        posterM.setImageResource(movie.getPhoto());

    }
}
