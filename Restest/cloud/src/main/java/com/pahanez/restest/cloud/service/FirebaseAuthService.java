package com.pahanez.restest.cloud.service;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.pahanez.restest.cloud.callback.AuthCallback;
import com.pahanez.restest.cloud.callback.CompletionCallback;
import com.pahanez.restest.cloud.callback.ErrorType;
import com.pahanez.restest.cloud.firebase.ConstFirebase;

/**
 * Created by pindziukou on 23/11/15.
 */
public class FirebaseAuthService implements AuthService {

    private Firebase mFirebase;

    public FirebaseAuthService(Firebase firebase) {
        mFirebase = firebase;
    }

    @Override
    public void signin(String cred1, String cred2, final AuthCallback callback) {
        mFirebase.authWithPassword(cred1, cred2, new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                com.pahanez.restest.cloud.entity.AuthData data = new com.pahanez.restest.cloud.entity.AuthData();
                data.addItem(ConstFirebase.AUTH_DATA_KEY, authData);
                callback.authComplete(data);
            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                ErrorType errorType = ErrorType.AUTH;
                callback.authError(errorType);
            }
        });
    }

    @Override
    public void signup(String cred1, String cred2, CompletionCallback callback) {
        mFirebase.createUser(cred1, cred2, new Firebase.ResultHandler() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(FirebaseError firebaseError) {
            }
        });

    }

    @Override
    public void signout(CompletionCallback callback) {
        mFirebase.unauth();
    }
}
