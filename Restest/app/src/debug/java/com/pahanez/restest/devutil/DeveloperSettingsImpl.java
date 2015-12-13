package com.pahanez.restest.devutil;

import android.support.annotation.NonNull;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp.StethoInterceptor;
import com.pahanez.restest.RestestApplication;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by pindziukou on 12/12/15.
 */
public class DeveloperSettingsImpl implements DeveloperSettings {

    @NonNull
    private final LeakCanaryProxy mLeakCanaryProxy;

    @NonNull
    private final RestestApplication mRestestApplication;

    @NonNull
    private final OkHttpClient mOkHttpClient;

    @NonNull
    private AtomicBoolean mLeakCanaryAlreadyEnabled = new AtomicBoolean();

    @NonNull
    private AtomicBoolean mStethoAlreadyEnabled = new AtomicBoolean();

    public DeveloperSettingsImpl(@NonNull RestestApplication restestApplication,
                                 @NonNull OkHttpClient okHttpClient,
                                 @NonNull LeakCanaryProxy leakCanaryProxy) {
        mRestestApplication = restestApplication;
        mLeakCanaryProxy = leakCanaryProxy;
        mOkHttpClient = okHttpClient;
    }

    @Override
    public void apply() {
        if (mLeakCanaryAlreadyEnabled.compareAndSet(false, true)) {
            mLeakCanaryProxy.init();
        }

        if (mStethoAlreadyEnabled.compareAndSet(false, true)) {
                Stetho.initializeWithDefaults(mRestestApplication);
            mOkHttpClient.interceptors().add(new StethoInterceptor());
        }
    }
}
