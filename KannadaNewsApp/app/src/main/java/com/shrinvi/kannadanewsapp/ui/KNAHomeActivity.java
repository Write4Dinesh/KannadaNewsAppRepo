package com.shrinvi.kannadanewsapp.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.shrinvi.kannadanewsapp.analytics.KNAGAEventsData;
import com.shrinvi.kannadanewsapp.analytics.KNAGoogleAnalytics;
import com.shrinvi.kannadanewsapp.model.KNAConstants;
import com.shrinvi.kannadanewsapp.model.KNAUtils;
import com.shrinvi.kannadanewsapp.R;

public class KNAHomeActivity extends AppCompatActivity {
    private AlertDialog mAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // KNAUtils.configLocale(this);
        AdView adView = findViewById(R.id.home_adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        adView.loadAd(adRequest);
    }

    public void onNewsButtonClick(View button) {
        if (!KNAUtils.isConnected(this)) {
            showErrorDialog(getString(R.string.error_not_connected));
            return;
        }
        switch (button.getId()) {
            case R.id.vk_button:
                launchBrowser(KNAConstants.VK_URL, getString(R.string.vk_button_label));
                break;
            case R.id.kp_button:
                launchBrowser(KNAConstants.KP_URL, getString(R.string.kp_button_label));
                break;
            case R.id.uv_button:
                launchBrowser(KNAConstants.UV_URL, getString(R.string.uv_button_label));
                break;
            case R.id.pv_button:
                launchBrowser(KNAConstants.PV_URL, getString(R.string.pv_button_label));
                break;
            case R.id.vv_button:
                launchBrowser(KNAConstants.VV_URL, getString(R.string.vv_button_label));
                break;
            case R.id.sv_button:
                launchBrowser(KNAConstants.SV_URL, getString(R.string.sv_button_label));
                break;
            case R.id.kk_button:
                launchBrowser(KNAConstants.KK_URL, getString(R.string.kk_button_label));
                break;
            case R.id.kr_button:
                launchBrowser(KNAConstants.KR_URL, getString(R.string.kr_button_label));
                break;
            case R.id.kd_button:
                launchBrowser(KNAConstants.KD_URL, getString(R.string.kd_button_label));
                break;
            case R.id.jm_button:
                launchBrowser(KNAConstants.JM_URL, getString(R.string.jm_button_label));
                break;
            case R.id.pp_button:
                launchBrowser(KNAConstants.PP_URL, getString(R.string.pp_button_label));
                break;
            case R.id.vb_button:
                launchBrowser(KNAConstants.VB_URL, getString(R.string.vb_button_label));
                break;
            case R.id.sn_button:
                launchBrowser(KNAConstants.SN_URL, getString(R.string.sn_button_label));
                break;
            case R.id.bn_button:
                launchBrowser(KNAConstants.BN_URL, getString(R.string.bn_button_label));
                break;
            case R.id.jv_button:
                launchBrowser(KNAConstants.JV_URL, getString(R.string.jv_button_label));
                break;
            case R.id.tc_button:
                launchBrowser(KNAConstants.TC_URL, getString(R.string.tc_button_label));
                break;
            case R.id.wd_button:
                launchBrowser(KNAConstants.WD_URL, getString(R.string.wd_button_label));
                break;
            case R.id.oi_button:
                launchBrowser(KNAConstants.OI_URL, getString(R.string.oi_button_label));
                break;
            case R.id.vvn_button:
                launchBrowser(KNAConstants.VVN_URL, getString(R.string.vvn_button_label));
                break;
        }

    }

    private void launchBrowser(String url, String title) {
        KNAGoogleAnalytics.sendCustomEvent(KNAGAEventsData.CUSTOM_EVENT_CATEGORY_LAUNCH_NEWS, title);
        Intent browserIntent = new Intent(this, KNABrowserActivity.class);
        browserIntent.putExtra(KNAConstants.INTENT_EXTRA_URL, url);
        browserIntent.putExtra(KNAConstants.INTENT_EXTRA_TITLE, title);
        startActivity(browserIntent);
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
}
