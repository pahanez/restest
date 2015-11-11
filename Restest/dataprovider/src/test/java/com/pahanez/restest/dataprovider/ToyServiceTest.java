package com.pahanez.restest.dataprovider;

import com.pahanez.restest.dataprovider.mock.MockToyService;
import com.pahanez.restest.dataprovider.mock.MockUtils;
import com.pahanez.restest.dataprovider.service.ToyService;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by pindziukou on 11/11/15.
 */
public class ToyServiceTest extends BaseTest {

    ToyService [] mToyServices = new ToyService[] {new MockToyService(MockUtils.createMockData())};

    @Test
    public void testAddingToy() {
        for(ToyService service : mToyServices) {
            Assert.assertNull(service.getAllToys());
        }
    }
}
