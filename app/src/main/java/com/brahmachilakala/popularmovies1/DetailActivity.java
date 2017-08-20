package com.brahmachilakala.popularmovies1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private TextView tvMovieTitle;
    private ImageView ivMovieThumbnail;
    private TextView tvMovieYear;
    private TextView tvMovieDuration;
    private TextView tvMovieRating;
    private TextView btFavorite;
    private TextView tvMovieOverview;


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
        tvMovieOverview = (TextView) findViewById(R.id.tv_movie_overview);

        tvMovieTitle.setText(getIntent().getStringExtra("original_title"));
        Picasso.with(this).load(getIntent().getStringExtra("image_url")).into(ivMovieThumbnail);
        tvMovieOverview.setText(getIntent().getStringExtra("overview"));
        tvMovieYear.setText(getIntent().getStringExtra("release_date"));
        tvMovieDuration.setText("Not available");
        tvMovieRating.setText(getIntent().getStringExtra("user_rating"));
        btFavorite.setText("Set as Favorite");
        btFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailActivity.this, "Implement this feature", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
