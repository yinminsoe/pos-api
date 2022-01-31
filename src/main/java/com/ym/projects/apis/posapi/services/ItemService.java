package com.ym.projects.apis.posapi.services;

import com.ym.projects.apis.posapi.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> findAllItem();
    Item findItemById(Long id);
    Item saveAndUpdateItem(Item itemType);
    void deleteItemById(Long id);
}
