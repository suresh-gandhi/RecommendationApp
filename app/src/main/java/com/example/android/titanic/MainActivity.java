package com.example.android.titanic;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.constraint.Guideline;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

import static android.R.attr.data;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;


//TODO: Make the App Rotation Off.
public class MainActivity extends AppCompatActivity {

    // Tag of the MainActivity for log messages.
    private static final String TAG = "MainActivity";

    // Any unauthenticated user will be named as anonymous.
    private static final String ANONYMOUS = "anonymous";

    // Request code for Sign In.
    private static final int RC_SIGN_IN = 1;

    // Username of the user currently signed in.
    public static String mUsername;

    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    private long mLastClickTime;
    //private int mLastClickedIndex;
    private int mSelectedListItemIndex;
    private ArrayList<UserDataField> mUserInputDataArray;
    private static int numberOfMoviesRated = 0;

    private MovieAdapter mMovieAdapter;
    private ListView mMoviesListView;
    private ArrayList<Movie> mMovies;

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.main_page_toolbar) ;
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Titanic");

        mMoviesListView = (ListView) findViewById(R.id.rate_list_view);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mUsername = ANONYMOUS;

        mLastClickTime = System.currentTimeMillis();
        mSelectedListItemIndex = -1;

        mMovies = QueryUtils.extractMovies();
        mMovieAdapter = new MovieAdapter(this, mMovies);
        mMoviesListView.setAdapter(mMovieAdapter);

        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_slide_out);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                mMovieAdapter.remove(mMovieAdapter.getItem(mSelectedListItemIndex));
                for (int i = mSelectedListItemIndex; i < mMovieAdapter.referenceArray.length - 1; i++) {
                    mMovieAdapter.referenceArray[i] = mMovieAdapter.referenceArray[i + 1];
                }

                mMovieAdapter.notifyDataSetChanged();
                numberOfMoviesRated += 1;
                if (numberOfMoviesRated == 5) {
                    // TODO: Launch a new activity and display the recommended movies.
                    // TODO RECOMMENDATION WORK
                    // TODO: Handle Back Button Presses Also here... See from all the perspectives...
                    MyAwesomeAsyncTask myAwesomeAsyncTask = new MyAwesomeAsyncTask();
                    myAwesomeAsyncTask.execute();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        mMoviesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // TODO: Take care of the positions of the clicks as well! Tiny Bug.
                long currTime = System.currentTimeMillis();
                if (currTime - mLastClickTime < ViewConfiguration.getDoubleTapTimeout()) {
                    onItemDoubleClick(adapterView, view, i, l);
                }
                mLastClickTime = currTime;
            }

            // TODO: Display Toast Message... or any other creativity
            public void onItemDoubleClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (mMovieAdapter.referenceArray[i] > 0) {
                    mSelectedListItemIndex = i;
                    view.startAnimation(animation);
                }
            }
        });

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            // This FirebaseAuth parameter is guaranteed to contain whether at this moment the user is authenticated or not.
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if (firebaseUser != null) {
                    onSignedInInitialize(firebaseUser.getDisplayName());
                } else {
                    onSignedOutCleanup();
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setProviders(
                                            AuthUI.EMAIL_PROVIDER,
                                            AuthUI.GOOGLE_PROVIDER)
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };
    }

    // TODO: Press Circular Button and then error comes. Also Refresh the list for the App to work.
    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mAuthStateListener != null) {
            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
        }
    }

    private void onSignedInInitialize(String username){
        mUsername = username;
    }

    private void onSignedOutCleanup(){
        mUsername = ANONYMOUS;
        if(!mMovies.isEmpty()) {
            mMovieAdapter.clear();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_SIGN_IN){
            if(resultCode == RESULT_OK){
                Toast.makeText(this, "Signed In", Toast.LENGTH_SHORT).show();
                mUsername = mFirebaseAuth.getCurrentUser().getDisplayName();
                GuideDialogFragment guideDialogFragment = new GuideDialogFragment();
                Toast.makeText(this, "Rate 5 movies", Toast.LENGTH_LONG).show();
                guideDialogFragment.show(getFragmentManager(), "guide");
                mMovies = QueryUtils.extractMovies();
                mMovieAdapter.addAll(mMovies);
                for(int i = 0; i < mMovieAdapter.referenceArray.length; i++){
                    mMovieAdapter.referenceArray[i] = 0;
                }
            }
            else if(resultCode == RESULT_CANCELED){
                Toast.makeText(this, "Sign in cancelled", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
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
                AuthUI.getInstance().signOut(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private class MyAwesomeAsyncTask extends AsyncTask<Void, Void, Void> {

        private ProgressDialog mProgress;

        @Override
        protected void onPreExecute() {
            mProgress = new ProgressDialog(MainActivity.this);
            mProgress.setTitle("");
            mProgress.setMessage("Fetching best movies for you...");
            mProgress.setCanceledOnTouchOutside(false);
            mProgress.show();
        }

        @Override
        protected Void doInBackground(Void... params) {

            long initialTimeCounter = System.currentTimeMillis();
            long finalTimeCounter = initialTimeCounter;
            while((finalTimeCounter - initialTimeCounter) < 4000){
                finalTimeCounter = System.currentTimeMillis();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            mProgress.dismiss();
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        }

    }

}
