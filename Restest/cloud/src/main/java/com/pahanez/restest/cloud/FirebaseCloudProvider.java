package com.pahanez.restest.cloud;


import com.firebase.client.Firebase;
import com.pahanez.restest.cloud.service.AuthService;
import com.pahanez.restest.cloud.service.FirebaseAuthService;
import com.pahanez.restest.cloud.service.ToyService;
import com.pahanez.restest.cloud.util.CloudInitializer;
import com.pahanez.restest.cloud.util.Constants;

/**
 * Created by pindziukou on 23/11/15.
 */
public class FirebaseCloudProvider implements CloudProvider {

    private Firebase mFirebase;

    @Override
    public void init(CloudInitializer initializer) {
        initializer.init();
        mFirebase = new Firebase(Constants.FIREBASE_API_URL);
    }

    @Override
    public ToyService getToyService() {
        return null;
    }

    @Override
    public AuthService getAuthService() {
        return new FirebaseAuthService(mFirebase);
    }
}
