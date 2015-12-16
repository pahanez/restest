package com.pahanez.restest.di.component;

import com.pahanez.restest.di.PerActivity;
import com.pahanez.restest.di.module.ActivityModule;
import com.pahanez.restest.di.module.RxModule;
import com.pahanez.restest.view.fragment.RxFragment;

import dagger.Component;

/**
 * Created by pindziukou on 14/12/15.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, RxModule.class})
public interface RxComponent {
    void inject(RxFragment rxFragment);
}
