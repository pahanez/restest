package com.pahanez.restest.view.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.pahanez.restest.di.PerActivity;
import com.pahanez.restest.util.RxSubscriber;
import com.pahanez.restest.view.RxView;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

@PerActivity
public class RxPresenter {

    private static final String TAG = RxPresenter.class.getSimpleName();

    private RxView mRxView;

    @Inject RxPresenter(){}

    public void setView(@NonNull RxView view) {
        this.mRxView = view;
    }

    public void onB1Clicked() {
        Log.e("p37td8", "onB1Clicked");

        Observable<String> obs = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                subscriber.onNext("adb uninstal com.waze");
                subscriber.onCompleted();
            }
        });

        Subscriber<String> ss = new RxSubscriber<String>();

        obs.subscribe(ss);


    }

    public void onB2Clicked() {
        Observable.from(new String[]{":1:", ":2:", ":3:"}).map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return s+"kk";
            }
        }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.e("p37td8", "ss: " + s);
            }
        });

    }
}
