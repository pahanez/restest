package com.pahanez.restest.network.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pahanez.restest.network.entity.NetToy;
import com.pahanez.restest.network.entity.serializer.ToyJsonAdapter;

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
