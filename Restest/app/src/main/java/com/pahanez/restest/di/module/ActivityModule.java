package com.pahanez.restest.di.module;

import android.app.Activity;

import com.pahanez.restest.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pindziukou on 13/12/15.
 */
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides
    @PerActivity
    Activity activity() {
        return this.activity;
    }
}
