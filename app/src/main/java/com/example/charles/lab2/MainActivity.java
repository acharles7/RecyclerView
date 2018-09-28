package com.example.charles.lab2;

import android.app.ActionBar;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    ChaDbSchema cds;
    private HomeFragment homeFragment;
    private LikeFragment likeFragment;
    private CommentFragment commentFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");


        cds = new ChaDbSchema(this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        if(savedInstanceState == null){

            getSupportFragmentManager().beginTransaction().replace(R.id.main_activity,new HomeFragment()).commit();
        }


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this ,ParentActivity.class));

            }
        });


    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            Fragment selectedFragment  = null;
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();


            switch (menuItem.getItemId()){
                case R.id.home:
                    selectedFragment = new HomeFragment();

                    break;
                case R.id.like:
                    selectedFragment = new LikeFragment();

                    break;
                case R.id.comment:
                    selectedFragment = new CommentFragment();
                    break;

            }

            getSupportFragmentManager().beginTransaction().replace(R.id.main_activity,selectedFragment).commit();


            return true;
        }
    };


}

