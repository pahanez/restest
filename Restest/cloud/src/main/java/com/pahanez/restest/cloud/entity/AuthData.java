package com.pahanez.restest.cloud.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pindziukou on 23/11/15.
 */
public class AuthData {

    Map<String, Object> mData = new HashMap<>();

    public void addItem(String key, Object object) {
        mData.put(key, object);
    }

    public boolean contains(String key) {
        return mData.containsKey(key);
    }

    public Object getItem(String key) {
        return mData.get(key);
    }
}
