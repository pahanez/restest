package com.pahanez.restest.dataprovider.service;

import java.util.List;

/**
 * Created by pindziukou on 10/11/15.
 */
public interface CrudService<T> {

    void createItem(T item);
    void updateItem(T item);
    void removeItem(T item);
    List<T> getAllItems();

}
