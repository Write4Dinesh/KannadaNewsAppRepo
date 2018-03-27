package com.shrinvi.kannadanewsapp.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.shrinvi.kannadanewsapp.analytics.KNAGoogleAnalytics;
import com.shrinvi.kannadanewsapp.model.DataProvider;
import com.shrinvi.kannadanewsapp.model.KNAConstants;
import com.shrinvi.kannadanewsapp.R;
import com.shrinvi.kannadanewsapp.model.KNANewsPaperAdapter;

public class KNAHomeActivity extends AppCompatActivity {
    private AlertDialog mAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // KNAUtils.configLocale(this);
        AdView adView = findViewById(R.id.home_adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(KNAConstants.AD_TEST_DEVICE_ID).build();
        adView.loadAd(adRequest);

        RecyclerView recyclerView = findViewById(R.id.np_recycler);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLayoutManager);
        KNANewsPaperAdapter adapter = new KNANewsPaperAdapter(DataProvider.getNewsPapers(this), this);
        recyclerView.setAdapter(adapter);
    }


    private void showErrorDialog(String errorMessage) {
        if (mAlertDialog == null) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            mAlertDialog = alertDialogBuilder.create();
        }
        mAlertDialog.setMessage(errorMessage);
        mAlertDialog.setButton(AlertDialog.BUTTON_POSITIVE, getString(R.string.alert_button_label), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mAlertDialog.dismiss();
            }
        });
        mAlertDialog.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        KNAGoogleAnalytics.sendScreenViewEvent("Home Screen");
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.rate_the_app:
                KNAGoogleAnalytics.sendScreenViewEvent("Rate the App Screen");
              launchPlayStore();
                return true;
            case R.id.about:
                KNAGoogleAnalytics.sendScreenViewEvent("About Us Screen");
                showErrorDialog(getString(R.string.about_us));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    private void launchPlayStore(){
        final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }

}
