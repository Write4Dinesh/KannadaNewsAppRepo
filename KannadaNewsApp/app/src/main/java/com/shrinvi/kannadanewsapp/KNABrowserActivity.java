package com.shrinvi.kannadanewsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class KNABrowserActivity extends AppCompatActivity {
    private WebView mKNAWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        mKNAWebView = findViewById(R.id.kna_webview);

        mKNAWebView.getSettings().setAllowContentAccess(true);
        mKNAWebView.getSettings().setJavaScriptEnabled(true);
        mKNAWebView.getSettings().setAppCacheEnabled(true);
        mKNAWebView.getSettings().setSupportZoom(true);
        mKNAWebView.getSettings().setBuiltInZoomControls(true);
        mKNAWebView.getSettings().setDisplayZoomControls(false);

        mKNAWebView.setWebViewClient(new KNAWebViewClient((ProgressBar) findViewById(R.id.progress_spinner)));

        String url = getIntent().getStringExtra(KNAConstants.INTENT_EXTRA_URL);
        if (url != null && !url.isEmpty()) {
            mKNAWebView.loadUrl(url);
        }
    }

    @Override
    public void onBackPressed() {
        if (mKNAWebView.canGoBack()) {
            mKNAWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
