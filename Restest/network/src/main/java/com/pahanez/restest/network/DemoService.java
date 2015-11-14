package com.pahanez.restest.network;

import com.pahanez.restest.network.entity.NetToy;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by pindziukou on 13/11/15.
 */
public interface DemoService {
    @GET("/ping/")
    Call<List<NetToy>> ping();
}
