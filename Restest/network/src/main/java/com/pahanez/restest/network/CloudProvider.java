package com.pahanez.restest.network;

import com.pahanez.restest.network.callback.CompletionCallback;

/**
 * Created by pindziukou on 21/11/15.
 */
public interface CloudProvider {
    public static class CloudProviderBuilder {
        int mType;


    }

    void signin(String creds1, String creds2, CompletionCallback callback);
    void signup(String creds1, String creds2, CompletionCallback callback);

    void getToyService();

}
