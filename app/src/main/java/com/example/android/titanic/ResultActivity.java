package com.example.android.titanic;

import android.animation.FloatArrayEvaluator;
import android.app.Fragment;
import android.graphics.drawable.ColorDrawable;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.util.List;

public class ResultActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    private SectionsPageAdapter mSectionsPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mToolbar = (Toolbar) findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Titanic");

        mViewPager = (ViewPager) findViewById(R.id.main_tab_pager);
        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mSectionsPageAdapter);

        mTabLayout = (TabLayout) findViewById(R.id.main_tabs);
        mTabLayout.setupWithViewPager(mViewPager);

        ImageView imageView = new ImageView(this);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.toyss));
        com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton fab =
                new com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton.Builder(this)
                        .setContentView(imageView).build();

        // TODO: Change this icon...1
        ImageView icon1 = new ImageView(this);
        icon1.setImageResource(R.drawable.horror);

        ImageView icon2 = new ImageView(this);
        icon2.setImageResource(R.drawable.comedyy);

        ImageView icon3 = new ImageView(this);
        icon3.setImageResource(R.drawable.adven);

        ImageView icon4 = new ImageView(this);
        icon4.setImageResource(R.drawable.heart);

        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);

        SubActionButton button1 = itemBuilder.setContentView(icon1).build();
        SubActionButton button2 = itemBuilder.setContentView(icon2).build();
        SubActionButton button3 = itemBuilder.setContentView(icon3).build();
        SubActionButton button4 = itemBuilder.setContentView(icon4).build();

        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(button1).addSubActionView(button2).addSubActionView(button3)
                .addSubActionView(button4).attachTo(fab).build();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ResultActivity.this, "Horror", Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ResultActivity.this, "Comedy", Toast.LENGTH_SHORT).show();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ResultActivity.this, "Adventure", Toast.LENGTH_SHORT).show();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ResultActivity.this, "Romantic", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public android.support.v4.app.Fragment getVisibleFragment(){
        FragmentManager fragmentManager = ResultActivity.this.getSupportFragmentManager();
        List<android.support.v4.app.Fragment> fragments = fragmentManager.getFragments();
        if(fragments != null){
            for(android.support.v4.app.Fragment fragment : fragments){
                if(fragment != null && fragment.isVisible())
                    return fragment;
            }
        }
        return null;
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
