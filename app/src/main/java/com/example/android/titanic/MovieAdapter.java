package com.example.android.titanic;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatRatingBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

/**
 * Created by summi on 25-08-2017.
 */

public class MovieAdapter extends ArrayAdapter<Movie>{

    private static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w1000";

    public int[] referenceArray;

    //TODO: Think if it can be used ahead as 500 or 185.

    public MovieAdapter(Context context, List<Movie> movies){
        super(context, 0, movies);
        this.referenceArray = new int[200];
    }

    // TODO: Dont forget to add the empty cases here.
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.rate_movie_list_item, parent, false);
        }

        Movie currentMovie = getItem(position);

        TextView movieTitleTextView = listItemView.findViewById(R.id.rate_title_text);
        ImageView movieBackdropImageView = listItemView.findViewById(R.id.rate_backdrop_image);
        AppCompatRatingBar ratingBar = (AppCompatRatingBar) listItemView.findViewById(R.id.rating_bar);

        movieTitleTextView.setText(currentMovie.getTitle());

        String currentMovieBackdropPath = currentMovie.getBackdropPath();
        String backdropUrl = IMAGE_BASE_URL + currentMovieBackdropPath;
        Glide.with(movieBackdropImageView.getContext()).load(backdropUrl).into(movieBackdropImageView);
        // TODO: Should the function be made??

        ratingBar.setProgress(referenceArray[position]);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                if(b) {
                    referenceArray[position] = (int) v;
                }
            }
        });

        return listItemView;
    }

}
