package com.pahanez.restest.cloud.firebase;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.pahanez.restest.cloud.util.Constants;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by pindziukou on 23/11/15.
 */
public class FirebaseTest {

    public static final String TAG = FirebaseTest.class.getSimpleName();

    private Firebase mFirebase;

    @Before
    public void setup() {
        mFirebase = new Firebase(Constants.FIREBASE_API_URL);
    }

    @Test
    public void testFirebase() {
        final String METHOD = " [testFirebase] ";
        System.out.println(TAG + METHOD);
        mFirebase.child("child11").setValue("child11_value", new Firebase.CompletionListener() {
            @Override
            public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                System.out.println(TAG + METHOD + "complette");
            }
        });

        sleep(5);
    }

    private void sleep(int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
