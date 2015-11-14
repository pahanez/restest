package com.pahanez.restest.network.util;

import android.support.annotation.NonNull;

import com.pahanez.restest.data.entity.Toy;
import com.pahanez.restest.network.entity.NetToy;

/**
 * Created by pindziukou on 13/11/15.
 */
public class ToyConvertor { //todo generic ? from/to converter

    public Toy from(@NonNull NetToy netToy) {
        Toy toy = new Toy();
        toy.setId(netToy.getId());
        toy.setName(netToy.getName());
        toy.setRed(netToy.isIsRed());
        toy.setChangedTime(netToy.getChangedTime());
        return toy;
    }

    public NetToy from(@NonNull Toy toy) {
        NetToy netToy = new NetToy();
        netToy.setId(toy.getId());
        netToy.setName(toy.getName());
        netToy.setIsRed(toy.isRed());
        netToy.setChangedTime(toy.getChangedTime());
        return netToy;
    }

}
