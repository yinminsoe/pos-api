package com.ym.projects.apis.posapi.services;

import com.ym.projects.apis.posapi.model.ItemCategory;

import java.util.List;

public interface ItemCategoryService {
    List<ItemCategory> findAllItemCategory();
    ItemCategory findItemCategoryById(Long id);
    ItemCategory saveAndUpdateItemCategory(ItemCategory itemType);
    void deleteItemCategoryById(Long id);
}
