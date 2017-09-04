package com.example.android.titanic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.firebase.ui.auth.AuthUI;

import java.util.ArrayList;

import static com.example.android.titanic.RecommendedMovieAdapter.convertGenreCodesToStrings;

public class RecommendedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommended);

        setTitle("Recommended Movies");

        ArrayList<Movie> recommendedMovies = QueryUtils.extractMoviesRecommended();

        ListView listView = (ListView) findViewById(R.id.list_view_recommended_activity);

        final RecommendedMovieAdapter recommendedMovieAdapter = new RecommendedMovieAdapter(this, recommendedMovies);

        listView.setAdapter(recommendedMovieAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Movie clickedMovie = recommendedMovieAdapter.getItem(i);
                Intent intent = new Intent(RecommendedActivity.this, MovieDetailsActivity.class);
                intent.putExtra("title", clickedMovie.getTitle());
                String genresString = RecommendedMovieAdapter.convertGenreCodesToStrings(clickedMovie.getGenres());
                intent.putExtra("genres", genresString);
                intent.putExtra("poster_path", clickedMovie.getPosterPath());
                intent.putExtra("backdrop_path", clickedMovie.getBackdropPath());
                intent.putExtra("tmdb_rating", clickedMovie.getTmdbRating());
                intent.putExtra("popularity", clickedMovie.getPopularity());
                intent.putExtra("tagline", clickedMovie.getTagline());
                intent.putExtra("overview", clickedMovie.getOverview());
                intent.putExtra("release_date", clickedMovie.getReleaseDate());
                intent.putExtra("runtime", clickedMovie.getRuntime());
                intent.putExtra("budget", clickedMovie.getBudget());
                intent.putExtra("homepage_url", clickedMovie.getHomePageUrl());
                intent.putExtra("imdb_id", clickedMovie.getImdbId());
                intent.putExtra("tmdb_id", clickedMovie.getTmdbId());
                intent.putExtra("adult", clickedMovie.isAdult());
                intent.putExtra("revenue", clickedMovie.getRevenue());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.sign_out_menu:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
