package com.pahanez.restest.view.activity;

import android.os.Bundle;

import com.pahanez.restest.R;
import com.pahanez.restest.di.HasComponent;
import com.pahanez.restest.di.component.DaggerRxComponent;
import com.pahanez.restest.di.component.RxComponent;
import com.pahanez.restest.di.module.ActivityModule;
import com.pahanez.restest.di.module.RxModule;
import com.pahanez.restest.view.fragment.RxFragment;

/**
 * Created by pindziukou on 14/12/15.
 */
public class RxActivity extends BaseActivity implements HasComponent<RxComponent> {

    private RxComponent mRxComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rx_activity);

        this.initializeActivity(savedInstanceState);
        this.initializeInjector();
    }

    /**
     * Initializes this activity.
     */
    private void initializeActivity(Bundle savedInstanceState) {
        addFragment(R.id.fl_fragment, RxFragment.newInstance());
    }

    private void initializeInjector() {
        mRxComponent = DaggerRxComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .rxModule(new RxModule())
                .build();
    }

    @Override
    public RxComponent getComponent() {
        return mRxComponent;
    }
}
