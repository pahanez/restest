package com.pahanez.restest.dataprovider.mock;

import com.pahanez.restest.data.entity.Toy;
import com.pahanez.restest.dataprovider.BuildConfig;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

/**
 * Created by pindziukou on 10/11/15.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 16)
public class MockingDataTest {

    private MockData mMockData;

    @Before
    public void setup() {
        mMockData = MockUtils.createMockData();
        Assert.assertTrue(mMockData.isInitialized());
    }

    @Test
    public void validateMockToys() {
        mMockData = MockUtils.createMockData();

        List<Toy> toyList = mMockData.getToyList();
        Toy firstToy = toyList.get(0);
        Assert.assertEquals("raspberrypi", firstToy.getName());
        Assert.assertEquals("25", firstToy.getId());
        Assert.assertEquals(false, firstToy.isRed());

        Toy secondToy = toyList.get(1);
        Assert.assertEquals("element", secondToy.getName());
        Assert.assertEquals("26", secondToy.getId());
        Assert.assertEquals(true, secondToy.isRed());

    }

}
