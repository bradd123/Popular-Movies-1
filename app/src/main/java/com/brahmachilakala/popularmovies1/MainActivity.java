package com.brahmachilakala.popularmovies1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

//    ArrayList<Movie> movies;
    RecyclerView rvMovies;
    MoviesAdapter rvAdapter;

    ArrayList<String> movieNames = new ArrayList<>(Arrays.asList("one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMovies = (RecyclerView) findViewById(R.id.rvMovies);

//        movies = Movie.createMovieList(10, this);

        rvAdapter = new MoviesAdapter();

        rvMovies.setAdapter(rvAdapter);

        rvMovies.setLayoutManager(new GridLayoutManager(this, 2));
    }
}
