package com.pahanez.restest.cloud.util;

import com.pahanez.restest.cloud.entity.NetToy;
import com.pahanez.restest.data.entity.Toy;

/**
 * Created by pindziukou on 13/11/15.
 */
public class ToyConvertor { //todo generic ? from/to converter

    public Toy from( NetToy netToy) {
        Toy toy = new Toy();
        toy.setId(netToy.getId());
        toy.setName(netToy.getName());
        toy.setRed(netToy.isIsRed());
        toy.setChangedTime(netToy.getChangedTime());
        return toy;
    }

    public NetToy from(Toy toy) {
        NetToy netToy = new NetToy();
        netToy.setId(toy.getId());
        netToy.setName(toy.getName());
        netToy.setIsRed(toy.isRed());
        netToy.setChangedTime(toy.getChangedTime());
        return netToy;
    }

}
