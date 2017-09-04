package com.example.android.titanic;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by summi on 27-08-2017.
 */

public class RecommendedMovieAdapter extends ArrayAdapter<Movie> {

    private static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w1000";

    private static final String GENRE_SEPARATOR = " | ";

    private static final int GENRE_ACTION = 28;
    private static final int GENRE_ADVENTURE = 12;
    private static final int GENRE_ANIMATION = 16;
    private static final int GENRE_COMEDY = 35;
    private static final int GENRE_CRIME = 80;
    private static final int GENRE_DOCUMENTARY = 99;
    private static final int GENRE_DRAMA = 18;
    private static final int GENRE_FAMILY = 10751;
    private static final int GENRE_FANTASY = 14;
    private static final int GENRE_HISTORY = 36;
    private static final int GENRE_HORROR = 27;
    private static final int GENRE_MUSIC = 10402;
    private static final int GENRE_MYSTERY = 9648;
    private static final int GENRE_ROMANCE = 10749;
    private static final int GENRE_SCIENCE_FICTION = 878;
    private static final int GENRE_TV_MOVIE = 10770;
    private static final int GENRE_THRILLER = 53;
    private static final int GENRE_WAR = 10752;
    private static final int GENRE_WESTERN = 37;

    public RecommendedMovieAdapter(Context context, List<Movie> movies){
        super(context, 0, movies);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listViewItem = convertView;
        if(listViewItem == null){
            listViewItem = LayoutInflater.from(this.getContext()).inflate(R.layout.recommended_list_item, parent, false);
        }

        Movie currentMovie = getItem(position);

        TextView movieTitleTextView = listViewItem.findViewById(R.id.recommended_title_text);
        TextView movieGenresTextView = listViewItem.findViewById(R.id.recommended_genres_text);
        ImageView movieBackdropImageView = listViewItem.findViewById(R.id.recommended_backdrop_image);
        // TODO: Add Popularity Image too with the rating
        TextView tmdbRatingTextView = listViewItem.findViewById(R.id.tmdb_rating_text_view);

        movieTitleTextView.setText(getItem(position).getTitle());

        // TODO: Handle Empty cases here
         ArrayList<Integer> genres = currentMovie.getGenres();
         String genreString = convertGenreCodesToStrings(genres);
         movieGenresTextView.setText(genreString);

        String currentMovieBackdropPath = currentMovie.getBackdropPath();
        String backdropUrl = IMAGE_BASE_URL + currentMovieBackdropPath;
        Glide.with(movieBackdropImageView.getContext()).load(backdropUrl).into(movieBackdropImageView);

        double tmdbRating = currentMovie.getTmdbRating();

        // TODO: Check its logic once
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        String tmdbRatingValue = decimalFormat.format(tmdbRating);
        tmdbRatingTextView.setText(tmdbRatingValue);

        tmdbRatingTextView.setVisibility(View.GONE);

        return listViewItem;
    }

    // TODO At Max 4 Genres and Abbreviate bigger names.
    public static String convertGenreCodesToStrings(ArrayList<Integer> genres){
        String genreString = "";
        for(int i = 0; i < genres.size(); i++) {
            switch (genres.get(i)) {
                case GENRE_ACTION:
                    genreString += "Action" + GENRE_SEPARATOR;
                    break;
                case GENRE_ADVENTURE:
                    genreString += "Adventure" + GENRE_SEPARATOR;
                    break;
                case GENRE_ANIMATION:
                    genreString += "Animation" + GENRE_SEPARATOR;
                    break;
                case GENRE_COMEDY:
                    genreString += "Comedy" + GENRE_SEPARATOR;
                    break;
                case GENRE_CRIME:
                    genreString += "Crime" + GENRE_SEPARATOR;
                    break;
                case GENRE_DOCUMENTARY:
                    genreString += "Documentary" + GENRE_SEPARATOR;
                    break;
                case GENRE_DRAMA:
                    genreString += "Drama" + GENRE_SEPARATOR;
                    break;
                case GENRE_FAMILY:
                    genreString += "Family" + GENRE_SEPARATOR;
                    break;
                case GENRE_FANTASY:
                    genreString += "Fantasy" + GENRE_SEPARATOR;
                    break;
                case GENRE_HISTORY:
                    genreString += "History" + GENRE_SEPARATOR;
                    break;
                case GENRE_HORROR:
                    genreString += "Horror" + GENRE_SEPARATOR;
                    break;
                case GENRE_MUSIC:
                    genreString += "Music" + GENRE_SEPARATOR;
                    break;
                case GENRE_MYSTERY:
                    genreString += "Mystery" + GENRE_SEPARATOR;
                    break;
                case GENRE_ROMANCE:
                    genreString += "Romance" + GENRE_SEPARATOR;
                    break;
                case GENRE_SCIENCE_FICTION:
                    genreString += "Sci-Fi" + GENRE_SEPARATOR;
                    break;
                case GENRE_THRILLER:
                    genreString += "Thriller" + GENRE_SEPARATOR;
                    break;
                case GENRE_TV_MOVIE:
                    genreString += "TV Movie" + GENRE_SEPARATOR;
                    break;
                case GENRE_WAR:
                    genreString += "War" + GENRE_SEPARATOR;
                    break;
                case GENRE_WESTERN:
                    genreString += "Western" + GENRE_SEPARATOR;
                    break;
            }
        }
        genreString = genreString.substring(0, genreString.length() - GENRE_SEPARATOR.length());
        return genreString;
    }
}
