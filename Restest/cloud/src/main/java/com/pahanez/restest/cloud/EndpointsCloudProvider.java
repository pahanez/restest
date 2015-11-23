package com.pahanez.restest.cloud;


import com.pahanez.restest.cloud.service.AuthService;
import com.pahanez.restest.cloud.service.ToyService;
import com.pahanez.restest.cloud.util.CloudInitializer;

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
