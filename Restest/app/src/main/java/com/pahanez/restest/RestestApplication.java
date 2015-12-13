package com.pahanez.restest;

import android.app.Application;

import com.pahanez.restest.devutil.DeveloperSettings;
import com.pahanez.restest.di.ApplicationModule;
import com.pahanez.restest.di.component.ApplicationComponent;
import com.pahanez.restest.di.component.DaggerApplicationComponent;

import javax.inject.Inject;

import dagger.Lazy;

/**
 * Created by pindziukou on 10/12/15.
 */
public class RestestApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Inject
    Lazy<DeveloperSettings> mDeveloperSettingModel;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
        getApplicationComponent().inject(this);

        if(BuildConfig.DEBUG) {
            mDeveloperSettingModel.get().apply();
        }
    }

    private void initializeInjector() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
