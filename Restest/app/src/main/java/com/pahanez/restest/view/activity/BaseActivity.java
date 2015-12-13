package com.pahanez.restest.view.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.pahanez.restest.RestestApplication;
import com.pahanez.restest.di.component.ApplicationComponent;

/**
 * Created by pindziukou on 13/12/15.
 */
public class BaseActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        this.getApplicationComponent().inject(this);
    }

    /**
     * Get the Main Application component for dependency injection.
     *
     * @return {@link com.pahanez.restest.RestestApplication}
     */
    protected ApplicationComponent getApplicationComponent() {
        return ((RestestApplication)getApplication()).getApplicationComponent();
    }
}
