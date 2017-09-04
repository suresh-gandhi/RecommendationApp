package com.example.android.titanic;

import java.util.ArrayList;

/**
 * Created by summi on 23-08-2017.
 */

public class Movie {

    private String mTitle;
    private String mTagline;
    private String mOverview;
    private String mReleaseDate;
    private String mHomePageUrl;

    private String mPosterPath;
    private String mBackdropPath;

    private String mImdbId;

    private int mRuntime;

    private long mTmdbId;
    private long mRevenue;
    private long mBudget;
    private long mVoteCount;

    private double mTmdbRating;
    private double mPopularity;

    private boolean mAdult;

    private ArrayList<Integer> mProductionCompanies;
    private ArrayList<Integer> mProductionCountries;

    private ArrayList<Integer> mGenres;

    //TODO: Empty Constructor...

    public Movie(String title, String backdropPath, double tmdbRating, ArrayList<Integer> genres, long tmdbId){
        this.mTitle = title;
        this.mBackdropPath = backdropPath;

        this.mTmdbRating = tmdbRating;

        this.mGenres = genres;

        this.mTmdbId = tmdbId;
    }

    public Movie(String title, String tagline, String overview, String releaseDate, String homePageUrl, String posterPath, String backdropPath, String imdbId, int runtime, long tmdbId, long revenue, long budget, long voteCount, double tmdbRating, double popularity, boolean adult, ArrayList<Integer> genres, ArrayList<Integer> productionCompanies, ArrayList<Integer> productionCountries) {
        this.mTitle = title;
        this.mTagline = tagline;
        this.mOverview = overview;
        this.mReleaseDate = releaseDate;
        this.mHomePageUrl = homePageUrl;
        this.mPosterPath = posterPath;
        this.mBackdropPath = backdropPath;
        this.mImdbId = imdbId;

        this.mRuntime = runtime;

        this.mTmdbId = tmdbId;
        this.mRevenue = revenue;
        this.mBudget = budget;
        this.mVoteCount = voteCount;

        this.mTmdbRating = tmdbRating;
        this.mPopularity = popularity;

        this.mAdult = adult;

        this.mGenres = genres;
        this.mProductionCompanies = productionCompanies;
        this.mProductionCountries = productionCountries;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getTagline() {
        return mTagline;
    }

    public String getOverview() {
        return mOverview;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public String getHomePageUrl() {
        return mHomePageUrl;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public String getBackdropPath() {
        return mBackdropPath;
    }

    public String getImdbId() {
        return mImdbId;
    }

    public int getRuntime() {
        return mRuntime;
    }

    public long getTmdbId() {
        return mTmdbId;
    }

    public long getRevenue() {
        return mRevenue;
    }

    public long getBudget() {
        return mBudget;
    }

    public long getVoteCount() {
        return mVoteCount;
    }

    public double getTmdbRating() {
        return mTmdbRating;
    }

    public double getPopularity() {
        return mPopularity;
    }

    public boolean isAdult() {
        return mAdult;
    }

    public ArrayList<Integer> getGenres() {
        return mGenres;
    }

    public ArrayList<Integer> getProductionCompanies() {
        return mProductionCompanies;
    }

    public ArrayList<Integer> getProductionCountries() {
        return mProductionCountries;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public void setTagline(String tagline) {
        this.mTagline = tagline;
    }

    public void setOverview(String overview) {
        this.mOverview = overview;
    }

    public void setReleaseDate(String releaseDate) {
        this.mReleaseDate = releaseDate;
    }

    public void setHomePageUrl(String homePageUrl) {
        this.mHomePageUrl = homePageUrl;
    }

    public void setPosterPath(String posterPath) {
        this.mPosterPath = posterPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.mBackdropPath = backdropPath;
    }

    public void setImdbId(String imdbId) {
        this.mImdbId = imdbId;
    }

    public void setRuntime(int runtime) {
        this.mRuntime = runtime;
    }

    public void setTmdbId(long tmdbId) {
        this.mTmdbId = tmdbId;
    }

    public void setRevenue(long revenue) {
        this.mRevenue = revenue;
    }

    public void setBudget(long budget) {
        this.mBudget = budget;
    }

    public void setVoteCount(long voteCount) {
        this.mVoteCount = voteCount;
    }

    public void setTmdbRating(double tmdbRating) {
        this.mTmdbRating = tmdbRating;
    }

    public void setPopularity(double popularity) {
        this.mPopularity = popularity;
    }

    public void setAdult(boolean adult) {
        this.mAdult = adult;
    }

    public void setGenres(ArrayList<Integer> genres) {
        this.mGenres = genres;
    }

    public void setProductionCompanies(ArrayList<Integer> productionCompanies) {
        this.mProductionCompanies = productionCompanies;
    }

    public void setProductionCountries(ArrayList<Integer> productionCountries) {
        this.mProductionCountries = productionCountries;
    }
}
