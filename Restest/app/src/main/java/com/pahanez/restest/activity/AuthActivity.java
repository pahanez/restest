package com.pahanez.restest.activity;

import com.pahanez.restest.R;
import com.pahanez.restest.defenition.AuthDef;
import com.pahanez.restest.gc.GcItem;
import com.pahanez.restest.presenter.AuthPresenter;
import com.pahanez.restest.presenter.BasePresenter;
import com.pahanez.restest.provider.AuthDataProvider;
import com.pahanez.restest.viewproxy.AuthViewProxy;

/**
 * Created by pindziukou on 06/12/15.
 */
public class AuthActivity extends BaseActivity {

    GcItem item = new GcItem("AuthActivity");

    @Override
    protected int getContentView() {
        return R.layout.act_auth;
    }

    @Override
    protected BasePresenter newPresenter() {
        AuthDef.IDataProvider dataProvider = new AuthDataProvider();
        AuthDef.IView view = new AuthViewProxy(this);
        return new AuthPresenter(dataProvider, view);
    }
}
