package com.pahanez.restest.viewproxy;

import android.app.Activity;

import com.pahanez.restest.defenition.AuthDef;
import com.pahanez.restest.gc.GcItem;

/**
 * Created by pindziukou on 06/12/15.
 */
public class AuthViewProxy extends BaseViewProxy<AuthDef.IPresenter> implements  AuthDef.IView {

    private GcItem item = new GcItem("AuthViewProxy");

    public AuthViewProxy(Activity activity) {
        super(activity);
    }

}
