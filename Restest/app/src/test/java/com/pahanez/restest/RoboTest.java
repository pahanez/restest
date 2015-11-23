package com.pahanez.restest;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by pindziukou on 18/11/15.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 16)
public class RoboTest {/*

    @Test
    public void test() {
        Context context = RuntimeEnvironment.application;
        Firebase.setAndroidContext(context);
        Firebase firebase = new Firebase("https://restest.firebaseio.com/");
        firebase.unauth();
        /*firebase.setPriority("core", new Firebase.CompletionListener() {
            @Override
            public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                System.out.println("1err" + firebaseError);
            }
        });
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
*/
}
