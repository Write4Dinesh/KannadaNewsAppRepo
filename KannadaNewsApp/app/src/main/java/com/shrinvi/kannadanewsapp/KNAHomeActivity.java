package com.shrinvi.kannadanewsapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class KNAHomeActivity extends AppCompatActivity {
    private AlertDialog mAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       // KNAUtils.configLocale(this);
    }

    public void onNewsButtonClick(View button) {
        if (!KNAUtils.isConnected(this)) {
            showErrorDialog(getString(R.string.error_not_connected));
            return;
        }
        switch (button.getId()) {
            case R.id.kp_button:
                launchBrowser(KNAConstants.KP_URL);
                break;
            case R.id.uv_button:
                launchBrowser(KNAConstants.UV_URL);
                break;
            case R.id.pv_button:
                launchBrowser(KNAConstants.PV_URL);
                break;
            case R.id.vv_button:
                launchBrowser(KNAConstants.VV_URL);
                break;
            case R.id.sv_button:
                launchBrowser(KNAConstants.SV_URL);
                break;
            case R.id.sk_button:
                launchBrowser(KNAConstants.SK_URL);
                break;
        }

    }

    private void launchBrowser(String url) {
        Intent browserIntent = new Intent(this, KNABrowserActivity.class);
        browserIntent.putExtra(KNAConstants.INTENT_EXTRA_URL, url);
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
}
