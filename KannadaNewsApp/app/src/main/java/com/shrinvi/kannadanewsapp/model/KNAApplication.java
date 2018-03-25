package com.shrinvi.kannadanewsapp.model;

import android.app.Application;

import com.shrinvi.kannadanewsapp.analytics.KNAGoogleAnalytics;

/**
 * Created by shrinvigroup on 25/03/2018.
 */

public class KNAApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        KNAUtils.configLocale(this);
        KNAGoogleAnalytics.init(this);
    }

}
