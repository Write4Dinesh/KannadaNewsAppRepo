package com.sgdm.KannadaNewsApp.storage;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by shrinvigroup on 27/03/2018.
 */

public class KNADataStore {
    private static final String MY_PREFS_NAME = "kna_preference_file";
    private static KNADataStore instance;
    private static Context mAppContext;
    private SharedPreferences mSharedPrefs;
    private SharedPreferences.Editor mEditor;

    private static final String LAST_AD_SHOW_TIME_IN_MILLIS = "last_ad_show_time_in_millis";

    private KNADataStore() {
        mSharedPrefs = mAppContext.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized KNADataStore getInstance(Context appContext) {
        mAppContext = appContext.getApplicationContext();
        if (instance == null) {
            instance = new KNADataStore();
        }
        return instance;
    }

    public void storeLastAddShowedTime(long timeInMillis) {
        if (mEditor == null) {
            mEditor = mSharedPrefs.edit();
        }
        mEditor.putLong(LAST_AD_SHOW_TIME_IN_MILLIS, timeInMillis);
        mEditor.commit();
    }

    public long getLastAddShowedTime() {
        return mSharedPrefs.getLong(LAST_AD_SHOW_TIME_IN_MILLIS, 0);
    }

}
