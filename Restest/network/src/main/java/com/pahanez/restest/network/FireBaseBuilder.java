package com.pahanez.restest.network;

import com.firebase.client.Firebase;

/**
 * Created by pindziukou on 17/11/15.
 */
public class FireBaseBuilder {

    public static void createFireBase() {
        Firebase firebase = new Firebase("https://restest.firebaseio.com/");
    }
}
