package com.pahanez.restest.context;

import android.util.Log;

/**
 * Created by pindziukou on 17/11/15.
 */
public class Application extends android.app.Application {

    private static final String TAG = Application.class.getSimpleName();

    @Override
    public void onCreate() {
        Log.i(TAG, "application started");

        super.onCreate();
    }

}
