package com.brahmachilakala.popularmovies1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView tvMovieTitle;
    private ImageView ivMovieThumbnail;
    private TextView tvMovieYear;
    private TextView tvMovieDuration;
    private TextView tvMovieRating;
    private TextView btFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvMovieTitle = (TextView) findViewById(R.id.tv_movie_title);
        ivMovieThumbnail = (ImageView) findViewById(R.id.iv_movie_thumbnail);
        tvMovieYear = (TextView) findViewById(R.id.tv_movie_year);
        tvMovieDuration = (TextView) findViewById(R.id.tv_movie_duration);
        tvMovieRating = (TextView) findViewById(R.id.tv_movie_rating);
        btFavorite = (TextView) findViewById(R.id.bt_favorite);
    }
}
