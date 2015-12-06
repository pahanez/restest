package com.pahanez.restest.viewproxy;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;

import com.pahanez.restest.R;
import com.pahanez.restest.defenition.Base;

public abstract class BaseViewProxy<P extends Base.IPresenter> implements Base.IView {

    private final View mCacheView;

    private P mPresenter;

    public BaseViewProxy(Activity activity) {
        this(activity.findViewById(android.R.id.content));
    }

    public BaseViewProxy(View rootView) {
        mCacheView = rootView;

        rootView.setTag(R.id.tag_view_proxy, this);

        onInit();
    }

    protected void onInit() {
        // nothing to do by default
    }

    @Override
    public void setPresenter(Base.IPresenter presenter) {
        mPresenter = (P) presenter;
    }

    public P getPresenter() {
        return mPresenter;
    }

    public <V extends View> V getRootView() {
        return (V) mCacheView;
    }

    @Override
    public Context getContext() {
        return getRootView().getContext();
    }

    @Override
    public Resources getResources() {
        return getRootView().getResources();
    }

}
