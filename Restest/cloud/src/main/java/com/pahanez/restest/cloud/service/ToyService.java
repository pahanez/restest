package com.pahanez.restest.cloud.service;

import com.pahanez.restest.cloud.callback.CompletionCallback;
import com.pahanez.restest.cloud.callback.CompletionCallbackExtended;
import com.pahanez.restest.cloud.entity.NetToy;
import com.pahanez.restest.data.entity.Toy;

/**
 * Created by pindziukou on 21/11/15.
 */
public interface ToyService {

    void createToy(Toy toy, CompletionCallback callback);
    void removeToy(Toy toy, CompletionCallback callback);
    void getAllToys(CompletionCallbackExtended callback);
    void updateToy(NetToy toy, CompletionCallback callback);

}
