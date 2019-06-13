package com.example.viiniimevada.bhagavad_gtasitis;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GIFScreen extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gifscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent mainIntent = new Intent(GIFScreen.this, DashboardActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}

