package com.brahmachilakala.popularmovies1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by brahma on 12/07/17.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

//    private List<Movie> mMovies;

//    private List<String> mMovieNames;
//    private Context mContext;

    public MoviesAdapter() {

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View movieView = inflater.inflate(R.layout.item_movie, parent, false);

        ViewHolder viewHolder = new ViewHolder(movieView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        Movie movie = mMovies.get(position);

        holder.movieImageView.setImageResource(R.drawable.happydog);

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView movieImageView;

        public ViewHolder(View itemView) {
            super(itemView);

            movieImageView = (ImageView) itemView.findViewById(R.id.movie_image);
        }
    }


}
