package com.ym.projects.apis.posapi.services;

import com.ym.projects.apis.posapi.entity.Item;

import java.util.List;

public interface ItemService {
    List<Item> findAllItem();
    Item findItemById(Long id);
    Item saveOrUpdateItem(Item itemType);
    void deleteItemById(Long id);
}
