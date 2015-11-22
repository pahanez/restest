package com.pahanez.restest.network.service;

import com.pahanez.restest.data.entity.Toy;
import com.pahanez.restest.network.callback.CompletionCallback;
import com.pahanez.restest.network.entity.NetToy;

import java.util.List;

/**
 * Created by pindziukou on 21/11/15.
 */
public interface ToyService {

    void createToy(Toy toy, CompletionCallback callback);
    void removeToy(Toy toy, CompletionCallback callback);
    List<Toy> getAllToys(CompletionCallback callback);
    void updateToy(NetToy toy, CompletionCallback callback);

}
