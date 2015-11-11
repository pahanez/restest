package com.pahanez.restest.dataprovider.mock;

import com.pahanez.restest.data.entity.Toy;
import com.pahanez.restest.dataprovider.service.ToyService;

import java.util.List;

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

    }

    @Override
    public void deleteToy(long id) {

    }

    @Override
    public List<Toy> getAllToys() {
        return null;
    }

    @Override
    public void updateToy(Toy toy) {

    }
}
