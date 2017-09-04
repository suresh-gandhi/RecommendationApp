package com.example.android.titanic;

/**
 * Created by summi on 26-08-2017.
 */

public class UserDataField {

    private Movie mMovie;
    private int mRating;

    public UserDataField(Movie movie, int rating) {
        this.mMovie = movie;
        this.mRating = rating;
    }

    public Movie getMovie() {
        return mMovie;
    }

    public int getRating() {
        return mRating;
    }

    public void setMovie(Movie movie) {
        this.mMovie = movie;
    }

    public void setRating(int rating) {
        this.mRating = rating;
    }
}
