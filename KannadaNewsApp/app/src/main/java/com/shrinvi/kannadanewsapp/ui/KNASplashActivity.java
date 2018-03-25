package com.shrinvi.kannadanewsapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.shrinvi.kannadanewsapp.analytics.KNAGoogleAnalytics;
import com.shrinvi.kannadanewsapp.model.KNAUtils;
import com.shrinvi.kannadanewsapp.R;

public class KNASplashActivity extends AppCompatActivity {
    public static final long LOAD_ANIMATION_DELAY_IN_MILLIS = 2 * 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        KNAUtils.configLocale(this);
        setContentView(R.layout.activity_splash);
        ImageView loadingIv = findViewById(R.id.splash_image_view);
        loadingIv.postDelayed(new Runnable() {
            @Override
            public void run() {
                launchHomeScreen();
            }
        }, LOAD_ANIMATION_DELAY_IN_MILLIS);
    }

    @Override
    protected void onStart() {
        super.onStart();
        KNAGoogleAnalytics.sendScrenViewEvent("Splash Screen");
    }
    private void launchHomeScreen() {
        Intent homeIntent = new Intent(this, KNAHomeActivity.class);
        startActivity(homeIntent);
        finish();
    }
}
