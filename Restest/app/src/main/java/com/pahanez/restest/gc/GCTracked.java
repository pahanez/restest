package com.pahanez.restest.gc;

/**
 * Created by pindziukou on 06/12/15.
 */
public abstract class GCTracked {
    public GcItem item = new GcItem(getName());
    public abstract String getName();
}
