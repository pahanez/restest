package com.pahanez.restest.cloud.service;


import com.pahanez.restest.cloud.callback.AuthCallback;
import com.pahanez.restest.cloud.callback.CompletionCallback;

/**
 * Created by pindziukou on 22/11/15.
 */
public interface AuthService {
    void signin(String cred1, String cred2, AuthCallback callback);
    void signup(String cred1, String cred2, CompletionCallback callback);
    void signout(CompletionCallback callback);
}
