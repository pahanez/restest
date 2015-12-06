package com.pahanez.restest.presenter;

import com.pahanez.restest.defenition.AuthDef;
import com.pahanez.restest.gc.GcItem;

/**
 * Created by pindziukou on 06/12/15.
 */
public class AuthPresenter extends BasePresenter<AuthDef.IDataProvider, AuthDef.IView> implements AuthDef.IPresenter {

    private GcItem item = new GcItem("AuthPresenter");

    public AuthPresenter(AuthDef.IDataProvider provider, AuthDef.IView view) {
        super(provider, view);
    }


}
