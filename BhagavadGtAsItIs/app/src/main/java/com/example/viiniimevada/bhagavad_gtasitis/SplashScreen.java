package com.example.viiniimevada.bhagavad_gtasitis;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen2);

 /*       ActionBar actionBar = getSupportActionBar();
        actionBar.hide();*/
        
        new Handler(). postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mintent = new Intent(SplashScreen.this, GIFScreen.class);
                startActivity(mintent);
                finish();
            }
        }, 2000);
    }
}
