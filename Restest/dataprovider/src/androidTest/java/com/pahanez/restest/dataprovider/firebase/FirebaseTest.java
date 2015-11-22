package com.pahanez.restest.dataprovider.firebase;

import android.test.InstrumentationTestCase;

/**
 * Created by pindziukou on 22/11/15.
 */
public class FirebaseTest extends InstrumentationTestCase {/*
    private static final String TAG = FirebaseTest.class.getSimpleName();


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        Log.d("p37td8", "setup");
        System.out.println("setup");
        Firebase.setAndroidContext(getInstrumentation().getContext());
    }

    @SmallTest
    public void testFirebase() {
        final String METHOD = "[testFirebase] ";
        Log.i(TAG, METHOD);

        Firebase firebase = new Firebase(Constants.FIREBASE_API_URL);
        firebase.child("peperoni").setValue("pizzq1", new Firebase.CompletionListener() {
            @Override
            public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                Log.i(TAG, METHOD + "onComplete: " + firebaseError + " , " + firebase);
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
    }*/
}
