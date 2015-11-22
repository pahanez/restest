package com.pahanez.restest.network.callback;

/**
 * Created by pindziukou on 21/11/15.
 */
public interface CompletionCallback {
    void onSuccess();
    void onError(ErrorType errorType);
}
