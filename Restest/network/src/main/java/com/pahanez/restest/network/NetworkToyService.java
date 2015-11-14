package com.pahanez.restest.network;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by pindziukou on 13/11/15.
 */
public class NetworkToyService {

    private DemoService mDemoService;

    public NetworkToyService(){
        init();
    }

    private void init() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://demo2233984.mockable.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mDemoService = retrofit.create(DemoService.class);
    }

    public DemoService getDemoService() {
        return mDemoService;
    }
}
