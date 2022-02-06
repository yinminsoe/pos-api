package com.ym.projects.apis.posapi.services;

import com.ym.projects.apis.posapi.entity.ItemCategory;

import java.util.List;

public interface ItemCategoryService {
    List<ItemCategory> findAllItemCategory();
    ItemCategory findItemCategoryById(Long id);
    ItemCategory saveOrUpdateItemCategory(ItemCategory itemCategory);
    void deleteItemCategoryById(Long id);
}
