package com.brahmachilakala.popularmovies1;

import android.content.Context;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by brahma on 12/07/17.
 */

public class Movie {
    private ImageView mMovieImageView;

    public Movie(ImageView imageView) {
        mMovieImageView = imageView;
    }

    public ImageView getMovieImage() {
        return mMovieImageView;
    }

    public void setMovieImage(ImageView imageView) {
        mMovieImageView = imageView;
    }

    public static ArrayList<Movie> createMovieList(int number, Context context) {
        ImageView image = new ImageView(context);
        image.setImageResource(R.drawable.happydog);

        ArrayList<Movie> movieList = new ArrayList<>();

        for(int i=0; i<number; i++) {
            Movie movie = new Movie(image);
            movieList.add(movie);
        }
        return movieList;
    }
}
