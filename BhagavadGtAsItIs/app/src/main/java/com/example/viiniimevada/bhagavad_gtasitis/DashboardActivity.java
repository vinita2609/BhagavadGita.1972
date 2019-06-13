package com.example.viiniimevada.bhagavad_gtasitis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.viiniimevada.bhagavad_gtasitis.Book1.MainActivity;
import com.example.viiniimevada.bhagavad_gtasitis.Book2.Book2Pdf;

public class DashboardActivity extends AppCompatActivity {


    private DrawerLayout drawer;
    private ImageView image1;
    private ImageView image2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashone);

/*
        //changing statusbar color
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.colorAccent));

        }

*/

      /*  new MaterialTapTargetPrompt.Builder(DashboardActivity.this)
                .setTarget(R.id.clickme)
                .setPrimaryText("Send your first email")
                .setSecondaryText("Tap the envelope to start composing your first email")
                .setPromptStateChangeListener(new MaterialTapTargetPrompt.PromptStateChangeListener()
                {
                    @Override
                    public void onPromptStateChanged(MaterialTapTargetPrompt prompt, int state)
                    {
                        if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED)
                        {
                            // User has pressed the prompt target
                        }
                    }
                })
                .show();*/


      /*  YoYo.with(Techniques.FlipInX)
                .duration(700)
                .repeat(1)
                .playOn(findViewById(R.id.clickme));

        YoYo.with(Techniques.FlipInX)
                .duration(700)
                .repeat(1)
                .playOn(findViewById(R.id.clicknow));*/


        image1 = (ImageView) findViewById(R.id.read1);
        image2 = (ImageView) findViewById(R.id.read2);


        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(DashboardActivity.this, Book2Pdf.class);
                startActivity(intent2);
            }
        });

        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

      *//*if (savedInstanceState == null) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new FragAboutApp()).commit();
        navigationView.setCheckedItem(R.id.aboutapp);}*//*
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_aboutapp:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragAboutApp()).commit();
                break;
            case R.id.nav_dedicate:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragDedicate()).commit();
                break;
    *//*   *//**//*     case R.id.nav_foreword:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragForeword()).commit();
                break;
            case R.id.nav_preface:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragPreface()).commit();*//**//*
                break;*//*
            case R.id.nav_intro:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragIntro()).commit();
                break;
            case R.id.nav_review:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragIntro()).commit();
                break;
     *//*       case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragIntro()).commit();
                break;*//*
            case R.id.nav_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }*/


    }

}

