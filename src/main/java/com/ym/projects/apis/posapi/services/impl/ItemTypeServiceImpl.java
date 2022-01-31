package com.ym.projects.apis.posapi.services.impl;

import com.ym.projects.apis.posapi.model.ItemType;
import com.ym.projects.apis.posapi.repositories.ItemTypeRepository;
import com.ym.projects.apis.posapi.services.ItemTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ItemTypeServiceImpl implements ItemTypeService {
    private final ItemTypeRepository itemTypeRepository;

    public ItemTypeServiceImpl(ItemTypeRepository itemTypeRepository) {
        this.itemTypeRepository = itemTypeRepository;
    }

    @Override
    public List<ItemType> findAllItemType() {
        return itemTypeRepository.findAll();
    }

    @Override
    public ItemType findItemTypeById(Long id) {
        return itemTypeRepository.findById(id).get();
    }

    @Override
    public ItemType saveAndUpdateItemType(ItemType itemType) {
        return itemTypeRepository.save(itemType);
    }

    @Override
    public void deleteItemTypeById(Long id) {
        itemTypeRepository.deleteById(id);
    }
}
