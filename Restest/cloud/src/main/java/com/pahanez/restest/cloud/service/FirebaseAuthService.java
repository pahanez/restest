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
    public void signup(String cred1, String cred2, final CompletionCallback callback) {
        mFirebase.createUser(cred1, cred2, new Firebase.ResultHandler() {
            @Override
            public void onSuccess() {
                callback.onSuccess();
            }

            @Override
            public void onError(FirebaseError firebaseError) {
                callback.onError(ErrorType.SIGNUP);
            }
        });
    }

    @Override
    public void signout(final CompletionCallback callback) {
        if (mFirebase.getAuth() == null) {
            //not logged in
            callback.onError(ErrorType.UNAUTH);
            return;
        }

        mFirebase.unauth(new Firebase.CompletionListener() {
            @Override
            public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                if (firebaseError != null) {
                    callback.onError(ErrorType.UNAUTH);
                } else {
                    callback.onSuccess();
                }
            }
        });
    }

    @Override
    public void removeUser(String cred1, String cred2, final CompletionCallback callback) {
        mFirebase.removeUser(cred1, cred2, new Firebase.ResultHandler() {
            @Override
            public void onSuccess() {
                callback.onSuccess();
            }

            @Override
            public void onError(FirebaseError firebaseError) {
                callback.onError(ErrorType.REMOVEUSER);
            }
        });
    }

    @Override
    public boolean isLoggedIn() {
        return mFirebase.getAuth() != null;
    }
}
