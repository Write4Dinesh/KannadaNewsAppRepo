package com.shrinvi.kannadanewsapp.model;

import android.app.Application;

import com.onesignal.OneSignal;
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
        // OneSignal Initialization
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
    }

}
