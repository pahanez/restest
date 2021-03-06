package com.pahanez.restest.cloud.service;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.gson.Gson;
import com.pahanez.restest.cloud.callback.CompletionCallback;
import com.pahanez.restest.cloud.callback.CompletionCallbackExtended;
import com.pahanez.restest.cloud.callback.ErrorType;
import com.pahanez.restest.data.entity.Toy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pindziukou on 24/11/15.
 */
public class FirebaseToyService implements ToyService {

    private static final String TAG = FirebaseToyService.class.getSimpleName();
    private static final String TOYS = "toys";

    private Firebase mFirebase;
    private Gson mGson = new Gson();

    public FirebaseToyService(Firebase firebase) {
        mFirebase = firebase;
        mFirebase = mFirebase.child(TOYS);
        if(firebase.getAuth() != null)
            mFirebase = mFirebase.child(mFirebase.getAuth().getUid());
    }

    @Override
    public void createToy(Toy toy, final CompletionCallback callback) {
        if(!isAuthorized()) {
            callback.onError(ErrorType.NOT_AUTHORIZED);
            return;
        }

        mFirebase.child(toy.getId()).setValue(toy, new Firebase.CompletionListener() {
            @Override
            public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                if(firebaseError == null) {
                    callback.onSuccess();
                } else {
                    callback.onError(ErrorType.CREATE);
                }
            }
        });

    }

    @Override
    public void removeToy(Toy toy, final CompletionCallback callback) {
        if(!isAuthorized()) {
            callback.onError(ErrorType.NOT_AUTHORIZED);
            return;
        }
        mFirebase.child(toy.getId()).removeValue(new Firebase.CompletionListener() {
            @Override
            public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                if(firebaseError == null) {
                    callback.onSuccess();
                } else {
                    callback.onError(ErrorType.CREATE);
                }
            }
        });


    }


    @Override
    public void getAllToys(final CompletionCallbackExtended callback) {
        if(!isAuthorized()) {
            callback.onError(ErrorType.NOT_AUTHORIZED);
        }

        mFirebase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                List<Toy> toys = new ArrayList<Toy>();
                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Toy toy = dataSnapshot.getValue(Toy.class);
                    toys.add(toy);
                }
                callback.onSuccess(toys);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                callback.onError(ErrorType.GET_ALL);
            }
        });
    }

    private class DiamondDogs {
        public Toy toy;
    }

    @Override
    public void updateToy(Toy toy, final CompletionCallback callback) {
        if(!isAuthorized()) {
            callback.onError(ErrorType.NOT_AUTHORIZED);
        }

        mFirebase.child(toy.getId()).setValue(toy, new Firebase.CompletionListener() {
            @Override
            public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                if(firebaseError == null) {
                    callback.onSuccess();
                } else {
                    callback.onError(ErrorType.UPDATE_ITEM);
                }
            }
        });



    }

    private boolean isAuthorized() {
        return mFirebase.getAuth() != null;
    }
}
