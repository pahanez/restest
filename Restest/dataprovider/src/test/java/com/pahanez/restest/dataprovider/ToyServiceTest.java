package com.pahanez.restest.dataprovider;

import com.pahanez.restest.data.entity.Toy;
import com.pahanez.restest.dataprovider.mock.MockToyService;
import com.pahanez.restest.dataprovider.mock.MockUtils;
import com.pahanez.restest.dataprovider.service.ToyService;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by pindziukou on 11/11/15.
 */
public class ToyServiceTest extends BaseTest {

    private ToyService mockToyService;

    @Before
    public void setup() {
        mockToyService = new MockToyService(MockUtils.createMockData());
    }

    @Test
    public void testAddingToy() {
        ToyService service = mockToyService;
        long toyCount = service.getAllToys().size();
        Assert.assertTrue(toyCount > 0);
        service.createToy("plasma_gun");
        long newToyCount = service.getAllToys().size();
        Assert.assertEquals(toyCount + 1, newToyCount);
    }

    @Test
    public void testRemoveToy() {
        ToyService service = mockToyService;
        long toyCount = service.getAllToys().size();
        Assert.assertTrue(toyCount > 0);
        service.deleteToy("25"); //remove raspberrypi
        long newToyCount = service.getAllToys().size();
        Assert.assertEquals(toyCount - 1, newToyCount);
    }

    @Test
    public void testUpdateToy() {
        String customName = "custom_toy_name";

        ToyService service = mockToyService;
        Toy toy = service.getAllToys().get(0);
        Assert.assertNotNull(toy.getName());
        toy.setName(customName);
        service.updateToy(toy);
        Toy updatedToy = service.getAllToys().get(0);
        Assert.assertEquals(customName, updatedToy.getName());
    }
}
