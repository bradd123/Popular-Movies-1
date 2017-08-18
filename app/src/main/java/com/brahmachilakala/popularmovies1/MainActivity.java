package com.brahmachilakala.popularmovies1;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Movie> movies;
    RecyclerView rvMovies;
    MoviesAdapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (isNetworkAvailable()) {
            new GetMoviesTask().execute("https://api.themoviedb.org/3/discover/movie?api_key=3afb8ecfbf45f15fa5dc9463f48976ed&sort_by=popularity.desc");
        }
    }

    private class GetMoviesTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.connect();
                InputStream in = conn.getInputStream();

                StringBuilder stringBuilder = new StringBuilder();

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String line;
                while((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }

                return stringBuilder.toString();


            } catch (Exception e) {
                Log.i("MainActivity", "error in parsing the url" + e.getMessage());
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {

            try {

                JSONObject response = new JSONObject(s);

                JSONArray moviesArray = response.getJSONArray("results");

                movies = Movie.fromJson(moviesArray);

                runRecyclerView();


            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private void runRecyclerView() {
        rvMovies = (RecyclerView) findViewById(R.id.rvMovies);

        rvAdapter = new MoviesAdapter(this, movies);

        rvMovies.setAdapter(rvAdapter);

        rvMovies.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
