package com.pahanez.restest.network.service;

import com.pahanez.restest.network.callback.CompletionCallback;

/**
 * Created by pindziukou on 22/11/15.
 */
public interface AuthService {
    void signin(String cred1, String cred2, CompletionCallback callback);
    void signup(String cred1, String cred2, CompletionCallback callback);
    void signout(CompletionCallback callback);
}
