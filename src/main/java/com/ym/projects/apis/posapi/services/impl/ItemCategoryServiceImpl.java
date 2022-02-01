package com.ym.projects.apis.posapi.services.impl;

import com.ym.projects.apis.posapi.model.ItemCategory;
import com.ym.projects.apis.posapi.repositories.ItemCategoryRepository;
import com.ym.projects.apis.posapi.services.ItemCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ItemCategoryServiceImpl implements ItemCategoryService {
    private final ItemCategoryRepository itemCategoryRepository;

    public ItemCategoryServiceImpl(ItemCategoryRepository itemCategoryRepository) {
        this.itemCategoryRepository = itemCategoryRepository;
    }

    @Override
    public List<ItemCategory> findAllItemCategory() {
        return itemCategoryRepository.findAll();
    }

    @Override
    public ItemCategory findItemCategoryById(Long id) {
        return itemCategoryRepository.findById(id).get();
    }

    @Override
    public ItemCategory saveOrUpdateItemCategory(ItemCategory itemCategory) {
        return itemCategoryRepository.save(itemCategory);
    }

    @Override
    public void deleteItemCategoryById(Long id) {
        itemCategoryRepository.deleteById(id);
    }
}
