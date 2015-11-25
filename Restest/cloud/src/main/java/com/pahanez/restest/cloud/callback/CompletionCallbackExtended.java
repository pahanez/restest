package com.pahanez.restest.cloud.callback;

/**
 * Created by pindziukou on 25/11/15.
 */
public interface CompletionCallbackExtended<T> extends CompletionCallback {
    void onSuccess(T result);
}
