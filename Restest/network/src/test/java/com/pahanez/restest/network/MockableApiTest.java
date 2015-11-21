package com.pahanez.restest.network;

import com.pahanez.restest.network.api.ToyApi;

import org.junit.Before;
import org.junit.Test;

import retrofit.Response;

/**
 * Created by pindziukou on 14/11/15.
 */
public class MockableApiTest {

    private ApiService mMockableService;
    private ToyApi mToyApi;

    @Before
    public void setup() {
        mMockableService = new ApiService.ApiServiceBuilder().setType(ApiService.GOOGLE_ENDPOINTS_API).build();
        mToyApi = mMockableService.getCommonApi();
    }

    @Test
    public void testGetEndpoins() throws Exception {
        Response<String> toyResponse = mToyApi.getEndpoints("Pashok").execute();
//        Response<Object> toyResponse = mToyApi.test().execute();
        System.out.println("rest" + toyResponse.code() + " , " + toyResponse.message());
    }

    /*@Test
    public void testGetToys() throws Exception {
        Response<List<NetToy>> toyResponse = mToyApi.getToys().execute();

        for(NetToy toy : toyResponse.body()) {
            System.out.println("toy : " + toy.getId() + " " + toy.getName() + " " + toy.isIsRed() + " , " + toy.getChangedTime());
        }
    }*/
}
