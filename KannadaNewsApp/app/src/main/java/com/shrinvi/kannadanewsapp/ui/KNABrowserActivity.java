package com.shrinvi.kannadanewsapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.shrinvi.kannadanewsapp.AppConfig;
import com.shrinvi.kannadanewsapp.analytics.KNAGoogleAnalytics;
import com.shrinvi.kannadanewsapp.model.KNAConstants;
import com.shrinvi.kannadanewsapp.model.KNAUtils;
import com.shrinvi.kannadanewsapp.model.KNAWebViewClient;
import com.shrinvi.kannadanewsapp.R;
import com.shrinvi.kannadanewsapp.storage.KNADataStore;

public class KNABrowserActivity extends KNASuperActivity {
    private WebView mKNAWebView;
    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        KNAUtils.configLocale(this);
        mKNAWebView = findViewById(R.id.kna_webview);
        mKNAWebView.getSettings().setAllowContentAccess(true);
        mKNAWebView.getSettings().setJavaScriptEnabled(true);
        mKNAWebView.getSettings().setAppCacheEnabled(true);
        mKNAWebView.getSettings().setSupportZoom(true);
        mKNAWebView.getSettings().setBuiltInZoomControls(true);
        mKNAWebView.getSettings().setDisplayZoomControls(false);

        mKNAWebView.setWebViewClient(new KNAWebViewClient((ProgressBar) findViewById(R.id.progress_spinner)));

        String url = getIntent().getStringExtra(KNAConstants.INTENT_EXTRA_URL);
        String title = getIntent().getStringExtra(KNAConstants.INTENT_EXTRA_TITLE);
        if (title != null && !title.isEmpty()) {
            getSupportActionBar().setTitle(title);
        }
        if (url != null && !url.isEmpty()) {
            mKNAWebView.loadUrl(url);
        }
        initBannerAd();
        initInterstitialAd();
    }

    private void initInterstitialAd() {
        // Create the InterstitialAd and set the adUnitId.
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.ad_unit_id_for_browse_interstitial));
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                finish();//close browser activity
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest);
    }

    @Override
    public void onBackPressed() {
        if (mKNAWebView.canGoBack()) {
            mKNAWebView.goBack();
        } else {
            showInterstitialAd();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        KNAGoogleAnalytics.sendScreenViewEvent("Browser Screen");
    }

    private void initBannerAd() {
        AdView adView = findViewById(R.id.browser_adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    private void showInterstitialAd() {
        long timeElapsedInMillis = System.currentTimeMillis() - KNADataStore.getInstance(this).getLastAddShowedTime();
        if (interstitialAd != null && interstitialAd.isLoaded() && (timeElapsedInMillis > 60 * 1000)) {
            KNAGoogleAnalytics.sendCustomEvent("AdMob", "ShowInterstitial");
            interstitialAd.show();
            KNADataStore.getInstance(this).storeLastAddShowedTime(System.currentTimeMillis());
        } else {
            KNAGoogleAnalytics.sendCustomEvent("AdMob", "ShowInterstitial:not loaded yet");
            finish();

        }
    }
}
