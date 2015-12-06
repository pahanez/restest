package com.pahanez.restest.gc;

/**
 * Created by pindziukou on 04/12/15.
 */
public class GcItem {

    private static int mCount = 0;
    private String mName;

    public GcItem(String name) {
        mName = name;
        ++mCount;
        android.util.Log.e("p37td8", "GcItem create : " + mCount + " : " + mName );
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        android.util.Log.e("p37td8", "finalize : " + mCount + " : " + mName );
    }
}
