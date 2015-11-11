package com.pahanez.restest.dataprovider.mock;

import android.content.Context;

import org.robolectric.RuntimeEnvironment;

/**
 * Created by pindziukou on 11/11/15.
 */
public class MockUtils {
    public static MockData createMockData() {
        Context context = RuntimeEnvironment.application.getApplicationContext();
        return new MockData(context);
    }
}
