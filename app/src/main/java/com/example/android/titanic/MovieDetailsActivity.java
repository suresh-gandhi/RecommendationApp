package com.example.android.titanic;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.auth.AuthUI;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

import static java.lang.System.load;

public class MovieDetailsActivity extends AppCompatActivity {

    private static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500";

    private ImageView mImdbImageView;
    private ImageView mTmdbImageView;

    private final static String IMDB_URL = "https://www.imdb.com/title/";
    private final static String TMDB_URL = "https://www.themoviedb.org/movie/";

    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        setTitle("Details");

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String title = bundle.getString("title");
        String posterPath = bundle.getString("poster_path");
        String backdropPath = bundle.getString("backdrop_path");
        String tagline = bundle.getString("tagline");
        String homePageUrl = bundle.getString("homepage_url");
        String releaseDate = bundle.getString("release_date");
        final String imdbId = bundle.getString("imdb_id");
        String overview = bundle.getString("overview");
        String genresString = bundle.getString("genres");

        double tmdbRating = bundle.getDouble("tmdb_rating");
        double popularity = bundle.getDouble("popularity");

        long budget = bundle.getLong("budget");
        final long tmdbId = bundle.getLong("tmdb_id");
        long revenue = bundle.getLong("revenue");

        int runtime = bundle.getInt("runtime");

        boolean isAdult = bundle.getBoolean("adult");

        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        mCollapsingToolbarLayout.setTitle(title);
        mCollapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent)); // transperent color = #00000000
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.rgb(255, 255, 255));

        ImageView backButtonImageView = (ImageView) findViewById(R.id.movie_details_back_button);
        backButtonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        TextView titleTextView = (TextView) findViewById(R.id.movie_details_title);
        titleTextView.setText(title);

        ImageView posterImageView = (ImageView)findViewById(R.id.movie_details_poster);
        Glide.with(posterImageView.getContext()).load(IMAGE_BASE_URL + posterPath).into(posterImageView);

        ImageView backdropImageView = (ImageView)findViewById(R.id.movie_details_backdrop_image);
        Glide.with(backdropImageView.getContext()).load(IMAGE_BASE_URL + backdropPath).into(backdropImageView);

        TextView taglineTextView = (TextView) findViewById(R.id.movie_details_tagline);
        taglineTextView.setText(tagline);

        TextView releaseDateTextView = (TextView) findViewById(R.id.movie_details_release_date);
        releaseDateTextView.setText(releaseDate);

        TextView overviewTextView = (TextView) findViewById(R.id.movie_details_overview);
        overviewTextView.setText(overview);

        TextView tmdbRatingTextView = (TextView) findViewById(R.id.movie_details_rating1);
        tmdbRatingTextView.setText(tmdbRating + "");

        TextView genresAboveTextView = (TextView) findViewById(R.id.movie_details_genres);
        genresAboveTextView.setText(genresString);

        TextView genresBelowTextView = (TextView) findViewById(R.id.movie_details_genres_below);
        genresBelowTextView.setText(genresString);

        TextView popularityTextView = (TextView) findViewById(R.id.movie_details_rating2);
        DecimalFormat df = new DecimalFormat("0.0");
        String formattedPopularity = df.format(popularity);
        popularityTextView.setText(formattedPopularity);

        TextView adultTextView = (TextView) findViewById(R.id.movie_details_rating3);
        if(isAdult){
            adultTextView.setText("Yes");
        }
        else{
            adultTextView.setText("No");
        }

        TextView budgetTextView = (TextView) findViewById(R.id.movie_details_budget);
        budgetTextView.setText("$" + budget);

        TextView runtimeTextView = (TextView) findViewById(R.id.movie_details_runtime);
        runtimeTextView.setText(runtime + " " + "min");

        TextView revenueTextView = (TextView) findViewById(R.id.movie_details_revenue);
        revenueTextView.setText("$" + revenue);

        mImdbImageView = (ImageView) findViewById(R.id.imdb_logo);
        mImdbImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri movieUri = Uri.parse(IMDB_URL + imdbId);
                Intent intent = new Intent(Intent.ACTION_VIEW, movieUri);
                startActivity(intent);
            }
        });

        mTmdbImageView = (ImageView) findViewById(R.id.tmdb_logo);
        mTmdbImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri movieUri = Uri.parse(TMDB_URL + tmdbId);
                Intent intent = new Intent(Intent.ACTION_VIEW, movieUri);
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
