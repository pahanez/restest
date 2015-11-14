package com.pahanez.restest.network;

import com.pahanez.restest.network.api.ToyApi;
import com.pahanez.restest.network.entity.NetToy;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import retrofit.Response;

/**
 * Created by pindziukou on 14/11/15.
 */
public class MockableApiTest {

    private ApiService mMockableService;
    private ToyApi mToyApi;

    @Before
    public void setup() {
        mMockableService = new ApiService.ApiServiceBuilder().setType(ApiService.MOCKABLE_API).build();
        mToyApi = mMockableService.getCommonApi();
    }

    @Test
    public void testGetToys() throws Exception {
        Response<List<NetToy>> toyResponse = mToyApi.getToys().execute();

        for(NetToy toy : toyResponse.body()) {
            System.out.println("toy : " + toy.getId() + " " + toy.getName() + " " + toy.isIsRed() + " , " + toy.getChangedTime());
        }
    }
}
