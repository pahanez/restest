package com.pahanez.restest.dataprovider.service;

import com.pahanez.restest.data.entity.Toy;

import java.util.List;

/**
 * Created by pindziukou on 10/11/15.
 */
public interface ToyService {

    void createToy(String name);
    void deleteToy(long id);
    List<Toy> getAllToys();
    void updateToy(Toy toy);

}
