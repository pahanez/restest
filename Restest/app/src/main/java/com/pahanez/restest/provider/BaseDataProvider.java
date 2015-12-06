package com.pahanez.restest.provider;


import com.pahanez.restest.defenition.Base;

public abstract class BaseDataProvider<P extends Base.IPresenter> implements Base.IDataProvider {

    private P mPresenter;

    @Override
    public void setPresenter(Base.IPresenter presenter) {
        mPresenter = (P) presenter;
    }

    public P getPresenter() {
        return mPresenter;
    }
}
