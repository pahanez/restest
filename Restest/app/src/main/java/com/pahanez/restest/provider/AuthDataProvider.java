package com.pahanez.restest.provider;

import com.pahanez.restest.defenition.AuthDef;
import com.pahanez.restest.gc.GcItem;

/**
 * Created by pindziukou on 06/12/15.
 */
public class AuthDataProvider extends BaseDataProvider<AuthDef.IPresenter> implements AuthDef.IDataProvider {

    GcItem item = new GcItem("AuthDataProvider");

}
