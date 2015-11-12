package com.pahanez.restest.dataprovider.mock;

import com.pahanez.restest.data.entity.Toy;
import com.pahanez.restest.dataprovider.service.ToyService;

import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by pindziukou on 11/11/15.
 */
public class MockToyService implements ToyService {

    private MockData mMockData;

    public MockToyService(MockData mockData) {
        mMockData = mockData;
    }


    @Override
    public void createToy(String name) {
        Toy newToy = new Toy(UUID.randomUUID().toString(), name, new Random().nextBoolean());
        mMockData.addToy(newToy);
    }

    @Override
    public void deleteToy(String id) {
        mMockData.removeToy(id);
    }

    @Override
    public List<Toy> getAllToys() {
        return mMockData.getToyList();
    }

    @Override
    public void updateToy(Toy toy) {
        mMockData.updateToy(toy);
    }
}
