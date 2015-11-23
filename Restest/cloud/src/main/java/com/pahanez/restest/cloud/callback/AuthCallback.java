package com.pahanez.restest.cloud.callback;


import com.pahanez.restest.cloud.entity.AuthData;

/**
 * Created by pindziukou on 23/11/15.
 */
public interface AuthCallback {
    void authComplete(AuthData authData);
    void authError(ErrorType type);
}
