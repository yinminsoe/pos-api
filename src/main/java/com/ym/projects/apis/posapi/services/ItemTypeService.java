package com.ym.projects.apis.posapi.services;

import com.ym.projects.apis.posapi.model.ItemType;

import java.util.List;

public interface ItemTypeService {
    List<ItemType> findAllItemType();
    ItemType findItemTypeById(Long id);
    ItemType saveAndUpdateItemType(ItemType itemType);
    void deleteItemTypeById(Long id);
}
