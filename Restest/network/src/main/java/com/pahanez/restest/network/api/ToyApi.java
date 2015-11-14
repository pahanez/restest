package com.pahanez.restest.network.api;

import com.pahanez.restest.network.entity.NetToy;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by pindziukou on 14/11/15.
 */
public interface ToyApi {
    @GET("/getToys/")
    Call<List<NetToy>> getToys();
}
