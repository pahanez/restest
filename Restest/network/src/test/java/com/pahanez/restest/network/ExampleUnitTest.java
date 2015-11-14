package com.pahanez.restest.network;

import com.pahanez.restest.network.api.ToyApi;
import com.pahanez.restest.network.entity.NetToy;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import retrofit.Response;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {

    private NetworkToyService mService;

    @Before
    public void setup() {
        mService = new NetworkToyService();
    }

    @Test
    public void addition_isCorrect() throws Exception {
        ApiService apiService = new ApiService.ApiServiceBuilder().setType(ApiService.MOCKABLE_API).build();
        ToyApi api = apiService.getCommonApi();

        Response<List<NetToy>> toyResponse = api.getToys().execute();
        for(NetToy toy : toyResponse.body()) {
            System.out.println("toy : " + toy.getId() + " " + toy.getName() + " " + toy.isIsRed() + " , " + toy.getChangedTime());
        }
    }
}