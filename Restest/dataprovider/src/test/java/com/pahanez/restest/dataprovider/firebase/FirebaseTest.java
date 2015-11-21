package com.pahanez.restest.dataprovider.firebase;

import android.content.Context;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.pahanez.restest.dataprovider.BaseTest;

import org.junit.Test;
import org.robolectric.RuntimeEnvironment;

/**
 * Created by pindziukou on 18/11/15.
 */
public class FirebaseTest extends BaseTest{

    @Test
    public void testFirebase(){
        Context context = RuntimeEnvironment.application;
        Firebase.setAndroidContext(context);
        Firebase firebase = new Firebase("https://restest.firebaseio.com/");
        firebase.unauth();
        /*firebase.setPriority("core", new Firebase.CompletionListener() {
            @Override
            public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                System.out.println("1err" + firebaseError);
            }
        });*/
        firebase.child("core").setValue("wow", new Firebase.CompletionListener() {
            @Override
            public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                System.out.println("_on complete_");
            }
        });
        firebase.child("custom_child").setValue("custom_value1", new Firebase.CompletionListener() {
            @Override
            public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                System.out.println("2err" + firebaseError);
            }
        });
        firebase.child("custom_child").setValue("custom_value2", new Firebase.CompletionListener() {
            @Override
            public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                System.out.println("3err" + firebaseError);
            }
        });
        firebase.push();

    }
}
