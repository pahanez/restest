package com.pahanez.restest.util;

import android.util.Log;

/**
 * Default subscriber base class to be used whenever you want default error handling.
 */
public class RxSubscriber<T> extends rx.Subscriber<T> {
    @Override public void onCompleted() {
        // no-op by default.
    }

    @Override public void onError(Throwable e) {
        // no-op by default.
    }

    @Override public void onNext(T t) {
        Log.e("p37td8", "" + t);
        // no-op by default.
    }
}
