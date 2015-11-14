package com.pahanez.restest.data.entity;

/**
 * Toy entity for sync
 */
public class Toy extends BaseEntity {

    private String mName;
    private boolean mIsRed;

    public Toy() {}

    public Toy (String id, String name, boolean isRed) {
        super(id);
        mName = name;
        mIsRed = isRed;
    }


    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public boolean isRed() {
        return mIsRed;
    }

    public void setRed(boolean mIsRed) {
        this.mIsRed = mIsRed;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "mId='" + mId + '\'' +
                "mName='" + mName + '\'' +
                "mChangedTime='" + mChangedTime + '\'' +
                ", mIsRed=" + mIsRed +
                '}';
    }
}
