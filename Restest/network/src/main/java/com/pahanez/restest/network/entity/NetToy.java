package com.pahanez.restest.network.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pindziukou on 13/11/15.
 */
public class NetToy {

    @SerializedName("id")
    private String mId;

    @SerializedName("changedTime")
    private long mChangedTime;

    @SerializedName("name")
    private String mName;

    @SerializedName("isRed")
    private boolean mIsRed;

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

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public boolean isIsRed() {
        return mIsRed;
    }

    public void setIsRed(boolean mIsRed) {
        this.mIsRed = mIsRed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NetToy netToy = (NetToy) o;

        if (mChangedTime != netToy.mChangedTime) return false;
        if (mIsRed != netToy.mIsRed) return false;
        if (mId != null ? !mId.equals(netToy.mId) : netToy.mId != null) return false;
        return !(mName != null ? !mName.equals(netToy.mName) : netToy.mName != null);

    }

    @Override
    public int hashCode() {
        int result = mId != null ? mId.hashCode() : 0;
        result = 31 * result + (int) (mChangedTime ^ (mChangedTime >>> 32));
        result = 31 * result + (mName != null ? mName.hashCode() : 0);
        result = 31 * result + (mIsRed ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "NetToy{" +
                "mId='" + mId + '\'' +
                ", mChangedTime=" + mChangedTime +
                ", mName='" + mName + '\'' +
                ", mIsRed=" + mIsRed +
                '}';
    }
}
