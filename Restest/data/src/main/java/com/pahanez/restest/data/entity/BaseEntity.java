package com.pahanez.restest.data.entity;

/**
 * Created by pindziukou on 10/11/15.
 */
public class BaseEntity {

    protected String mId;
    protected long mChangedTime;

    public BaseEntity (String id) {
        mId = id;
        mChangedTime = System.currentTimeMillis();
    }


    public String getId() {
        return mId;
    }

    public void setId(String mId) {
        this.mId = mId;
    }

    public long getChangedTime() {
        return mChangedTime;
    }

    public void setChangedTime(long mChangedTime) {
        this.mChangedTime = mChangedTime;
    }
}
