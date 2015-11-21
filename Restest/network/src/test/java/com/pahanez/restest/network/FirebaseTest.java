package com.pahanez.restest.network;

import com.firebase.client.Firebase;

import org.junit.Test;

/**
 * Created by pindziukou on 18/11/15.
 */
public class FirebaseTest {

    @Test
    public void testFirebaseObjectCreation() {
        Firebase firebase = new Firebase("https://restest.firebaseio.com/");
        firebase.child("custom_child").setValue("custom_value");
    }
}
