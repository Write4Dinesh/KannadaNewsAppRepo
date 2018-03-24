package com.shrinvi.kannadanewsapp;

import android.app.Application;

/**
 * Created by shrinvigroup on 25/03/2018.
 */

public class KNAApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        KNAUtils.configLocale(this);
    }

}
