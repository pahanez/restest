package com.pahanez.restest.devutil;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.pahanez.restest.RestestApplication;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

public class LeakCanaryProxyImpl implements LeakCanaryProxy {

    @NonNull
    private final RestestApplication mRestestApplication;

    @Nullable
    private RefWatcher refWatcher;

    public LeakCanaryProxyImpl(@NonNull RestestApplication restestApplication) {
        mRestestApplication = restestApplication;
    }

    @Override
    public void init() {
        refWatcher = LeakCanary.install(mRestestApplication);
    }

    @Override
    public void watch(@NonNull Object object) {
        if (refWatcher != null) {
            refWatcher.watch(object);
        }
    }
}
