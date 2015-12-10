package com.pahanez.restest.dataprovider;

import com.pahanez.restest.dataprovider.service.AuthService;

/**
 * Created by pindziukou on 07/12/15.
 */
public interface ServiceProvider {

    AuthService getAuthService();

}
