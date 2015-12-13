package com.pahanez.restest.di;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import com.pahanez.restest.RestestApplication;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module for application level dependencies.
 * Live during the mApplication lifecycle.
 * */
@Module
public class ApplicationModule {

    public static final String MAIN_THREAD_HANDLER = "main_thread_handler";

    @NonNull
    private final RestestApplication mApplication;

    public ApplicationModule(@NonNull RestestApplication application) {
        this.mApplication = application;
    }

    @Provides @NonNull @Singleton
    Context provideApplicationContext() {
        return this.mApplication;
    }

    @Provides @NonNull @Singleton
    RestestApplication provideRestestApplication() {
        return this.mApplication;
    }

    @Provides @NonNull @Named(MAIN_THREAD_HANDLER) @Singleton
    public Handler provideMainThreadHandler() {
        return new Handler(Looper.getMainLooper());
    }

    //todo Navigator -> ...startActivity
    //todo background thread
    //todo main thread
}
