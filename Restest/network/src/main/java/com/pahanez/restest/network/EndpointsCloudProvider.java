package com.pahanez.restest.network;


import com.pahanez.restest.network.service.AuthService;
import com.pahanez.restest.network.service.ToyService;
import com.pahanez.restest.network.util.CloudInitializer;

/**
 * Created by pindziukou on 21/11/15.
 */
public class EndpointsCloudProvider implements CloudProvider {

    @Override
    public void init(CloudInitializer initializer) {
        initializer.init();
    }

    @Override
    public ToyService getToyService() {
        return null;
    }

    @Override
    public AuthService getAuthService() {
        return null;
    }
}
