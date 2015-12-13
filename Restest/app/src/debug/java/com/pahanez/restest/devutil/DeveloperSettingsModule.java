package com.pahanez.restest.devutil;

import android.support.annotation.NonNull;

import com.pahanez.restest.RestestApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pindziukou on 12/12/15.
 */
@Module
public class DeveloperSettingsModule {

    @Provides
    @NonNull
    @Singleton
    public LeakCanaryProxy provideLeakCanaryProxy(@NonNull RestestApplication restestApplication) {
        return new LeakCanaryProxyImpl(restestApplication);
    }
}
