package com.pahanez.restest.network.entity.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.pahanez.restest.network.entity.NetToy;

import java.lang.reflect.Type;

/**
 * Created by pindziukou on 13/11/15.
 */
public class ToyJsonAdapter implements JsonSerializer<NetToy> {
    @Override
    public JsonElement serialize(NetToy src, Type typeOfSrc, JsonSerializationContext context) {
//        JsonObject jsonNetToy = new JsonObject();
//        jsonNetToy.addProperty();
        return null;
    }
}
