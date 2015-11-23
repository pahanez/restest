package com.pahanez.restest.cloud.callback;

/**
 * Created by pindziukou on 21/11/15.
 */
public interface CompletionCallback {
    void onSuccess();
    void onError(ErrorType errorType);
}
