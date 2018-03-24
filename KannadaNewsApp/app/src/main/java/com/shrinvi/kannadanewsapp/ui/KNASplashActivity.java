package com.shrinvi.kannadanewsapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.shrinvi.kannadanewsapp.model.KNAUtils;
import com.shrinvi.kannadanewsapp.R;

public class KNASplashActivity extends AppCompatActivity {
    public static final long LOAD_ANIMATION_DELAY_IN_MILLIS = 3 * 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        KNAUtils.configLocale(this);
        ImageView loadingIv = findViewById(R.id.splash_image_view);
        loadingIv.postDelayed(new Runnable() {
            @Override
            public void run() {
                launchHomeScreen();
            }
        }, LOAD_ANIMATION_DELAY_IN_MILLIS);
    }


    private void launchHomeScreen() {
        Intent homeIntent = new Intent(this, KNAHomeActivity.class);
        startActivity(homeIntent);
        finish();
    }
}
