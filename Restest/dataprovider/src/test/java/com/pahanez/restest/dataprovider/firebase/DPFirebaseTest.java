package com.pahanez.restest.dataprovider.firebase;

import com.pahanez.restest.dataprovider.BaseTest;

/**
 * Created by pindziukou on 18/11/15.
 */
public class DPFirebaseTest extends BaseTest {/*

    private CloudProvider mCloudProvider;
    private static final String EMAIL = "roboadmin@robo.cop";
    private static final String PSWD = "robopass";
    private static final String TOYS = "toys";
    private static final String USERS = "users";


    @Before
    public void setup() {
        Context context = RuntimeEnvironment.application;
        Firebase.setAndroidContext(context);
        mCloudProvider = new CloudProvider.CloudProviderBuilder().setType(CloudProvider.FIREBASE).build();
    }


//    @Test
    public void auth() {
        Firebase firebase = new Firebase(Constants.FIREBASE_API_URL);

        Firebase.AuthResultHandler handler = new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                System.out.println("onAuthenticated");
            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                System.out.println("onAuthenticationError");
            }
        };

        firebase.authWithPassword(EMAIL, PSWD, handler);
        sleep(5);
//        handler = Mockito.spy(handler);

//        mCloudProvider.signin(EMAIL, PSWD, handler);
        System.err.println("uid: " + firebase.getAuth().getUid());
        String token = firebase.getAuth().getUid();
        Toy toy1 = new Toy(UUID.randomUUID().toString(), "toy1", true);
        Toy toy2 = new Toy(UUID.randomUUID().toString(), "toy2", false);
        Toy toy3 = new Toy(UUID.randomUUID().toString(), "toy3", true);

        firebase.setValue("");

        firebase.child(USERS).child(token).child(TOYS).child(toy1.getId()).setValue(toy1);
        firebase.child(USERS).child(token).child(TOYS).child(toy2.getId()).setValue(toy2);
        firebase.child(USERS).child(token).child(TOYS).child(toy3.getId()).setValue(toy3);
        sleep(5);


        ShadowApplication.runBackgroundTasks();
        System.out.println("runBackgroundTasks");
        firebase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.err.println("uid: ");

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.err.println("onCancelled");
                Log.e("p37td8", "onCancelled");
            }
        });

        sleep(9);
//        query.getRepo().
//        firebase.child(token).child(TOYS).child(toy1.getId()).getRepo().

//        AuthData authData = firebase.getAuth();
//        System.out.println("aData: " + authData.toString());
//        System.out.println("setup_complete");
//        Toy toy = new Toy(UUID.randomUUID().toString(), "toy12", true);
//        mCloudProvider.getToyService().storeToy(toy);
//        sleep(6);
    }

//    @Test
//    public void testFirebase() {
//        Toy toy = new Toy(UUID.randomUUID().toString(), "toy7", true);
//        mCloudProvider.getToyService().storeToy(toy);
//        sleep(6);
//    }

    @Test
    public void testFirebaseCallback() {
        Firebase firebase = new Firebase(Constants.FIREBASE_API_URL);
        firebase.setValue("clera");
        firebase.child("custom_child").setValue("custom_value", new Firebase.CompletionListener() {
            @Override
            public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                System.out.println("never goes here");
            }
        });

        sleep(10);
    }


    private void sleep(int value) {
        try {
            TimeUnit.SECONDS.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    */
}
