package com.pahanez.restest.di.module;

import android.support.annotation.NonNull;

import com.pahanez.restest.RestestApplication;
import com.pahanez.restest.devutil.DeveloperSettings;
import com.pahanez.restest.devutil.DeveloperSettingsImpl;
import com.pahanez.restest.devutil.LeakCanaryProxy;
import com.pahanez.restest.devutil.LeakCanaryProxyImpl;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pindziukou on 11/12/15.
 */
@Module
public class DevelopersModule {


    @Provides
    @NonNull
    @Singleton
    public LeakCanaryProxy provideLeakCanaryProxy(@NonNull RestestApplication application) {
        return new LeakCanaryProxyImpl(application);
    }

    // We will use this concrete type for debug code, but main code will see only DeveloperSettingsModel interface.
    @Provides
    @NonNull
    @Singleton
    public DeveloperSettings provideDeveloperSettings(@NonNull RestestApplication application,
                                                                   @NonNull OkHttpClient okHttpClient,
                                                                   @NonNull LeakCanaryProxy leakCanaryProxy) {
        return new DeveloperSettingsImpl(application, okHttpClient, leakCanaryProxy);
    }
}
