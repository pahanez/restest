package com.pahanez.restest.cloud.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pahanez.restest.cloud.entity.NetToy;
import com.pahanez.restest.cloud.entity.serializer.ToyJsonAdapter;

/**
 * Created by pindziukou on 13/11/15.
 */
public class Utils {
    public Gson buildGson() {
        GsonBuilder gson = new GsonBuilder();
        gson.registerTypeAdapter(NetToy.class, new ToyJsonAdapter());
        return gson.create();
    }
}
